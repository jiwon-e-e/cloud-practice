package com.example.membermanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.hibernate.validator.constraints.Range;

@Getter
public class CreateMemberRequest {
    @NotBlank(message = "이름은 필수입니다.")
    @Size(max = 10, message = "10자 내로 입력해야합니다.")
    private String name;

    @NotNull(message = "나이는 필수입니다.")
    @Range(max = 100, message = "허용되지 않는 나이 범위입니다.")
    private int age;

    @NotBlank(message = "mbti 값은 필수입니다.")
    private String mbti;



}
