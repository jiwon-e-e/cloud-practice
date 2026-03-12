package com.example.membermanagement.service;

import com.example.membermanagement.dto.FileUploadResponse;
import com.example.membermanagement.global.exception.ErrorCode;
import com.example.membermanagement.global.exception.ServiceException;
import com.example.membermanagement.dto.CreateMemberRequest;
import com.example.membermanagement.dto.CreateMemberResponse;
import com.example.membermanagement.dto.GetMemberResponse;
import com.example.membermanagement.entity.MBTI;
import com.example.membermanagement.entity.Member;
import com.example.membermanagement.repository.MemberRepository;
import io.awspring.cloud.s3.S3Template;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;
    private static final Duration PRESIGNED_URL_EXPIRATION = Duration.ofMinutes(10);
    private final S3Template s3Template;
    @Value("${spring.cloud.aws.s3.bucket}")
    private String bucket;

    //1. 멤버 저장
    @Transactional
    public CreateMemberResponse saveMember(CreateMemberRequest request) {
        Member member = memberRepository.save(new Member(
                request.getName(),
                request.getAge(),
                MBTI.from(request.getMbti())
        ));

        return new CreateMemberResponse(
                member.getId(),
                member.getName(),
                member.getAge(),
                member.getMbti().name(),
                member.getCreatedAt()
        );
    }

    // 2. 멤버 단건 조회
    public GetMemberResponse getOneMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                ()-> new ServiceException(ErrorCode.MEMBER_NOT_FOUND)
        );

        String key = member.getProfileImage();

        String imageString = null;

        if (key != null){
            imageString = s3Template.createSignedGetURL(bucket, key, PRESIGNED_URL_EXPIRATION).toString();

        }

        return new GetMemberResponse(
                member.getId(),
                member.getName(),
                member.getAge(),
                member.getMbti().name(),
                imageString,
                member.getCreatedAt()
        );
    }

    // 3. 프로필 사진 올리기
    @Transactional
    public FileUploadResponse upload(Long memberId, MultipartFile file){
        Member member = memberRepository.findById(memberId).orElseThrow(
                ()-> new ServiceException(ErrorCode.MEMBER_NOT_FOUND)
        );

        try {
            String key = "uploads/" + UUID.randomUUID() + "_" + file.getOriginalFilename();
            s3Template.upload(bucket, key, file.getInputStream());
            member.setProfileImage(key);
            return new FileUploadResponse(key);
        } catch (IOException e) {
            throw new ServiceException(ErrorCode.FILE_UPLOAD_FAILED);
        }
    }

    // 4. 프로필 사진 url 만 조회
    public URL download(Long memberId){
        Member member = memberRepository.findById(memberId).orElseThrow(
                ()-> new ServiceException(ErrorCode.MEMBER_NOT_FOUND)
        );

        String key = member.getProfileImage();
        if (key == null){
            throw new ServiceException(ErrorCode.IMAGE_NOT_FOUND);
        }

        return s3Template.createSignedGetURL(bucket, key, PRESIGNED_URL_EXPIRATION);
    }
}
