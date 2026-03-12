package com.example.membermanagement.controller;

import com.example.membermanagement.dto.*;
import com.example.membermanagement.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;

@RestController
@Slf4j
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    //1. 팀원 새로 저장하기
    @PostMapping("/api/members")
    ResponseEntity<CreateMemberResponse> create(@Valid @RequestBody CreateMemberRequest request){

        CreateMemberResponse response = memberService.saveMember(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    //2. 팀원 단건조회
    @GetMapping("/api/members/{memberId}")
    ResponseEntity<GetMemberResponse> getOne(@PathVariable Long memberId){

        GetMemberResponse response = memberService.getOneMember(memberId);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    //3. 팀원 프로필 이미지 등록
    @PostMapping("/api/members/{memberId}/profile-image")
    ResponseEntity<FileUploadResponse> uploadImage(
            @RequestParam("file") MultipartFile file,
            @PathVariable Long memberId) {

        FileUploadResponse response = memberService.upload(memberId, file);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    //4. 프로필 이미지 URL 반환
    @GetMapping("/api/members/{memberId}/profile-image")
    public ResponseEntity<FileDownloadResponse> getDownloadUrl(
            @PathVariable Long memberId) {
        URL url = memberService.download(memberId);

        FileDownloadResponse response = new FileDownloadResponse(url.toString());

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
