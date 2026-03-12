package com.example.membermanagement.entity;

import com.example.membermanagement.global.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "members")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false)
    @Max(100)
    private int age;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MBTI mbti;

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    private String profileImage;

    public Member(String name, int age, MBTI mbti) {
        this.name = name;
        this.age = age;
        this.mbti = mbti;
    }


}
