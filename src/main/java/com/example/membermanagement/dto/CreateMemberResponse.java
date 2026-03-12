package com.example.membermanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CreateMemberResponse {
    private final Long id;
    private final String name;
    private final int age;
    private final String mbti;
    private final LocalDateTime createdAt;
}
