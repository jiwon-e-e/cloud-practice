package com.example.membermanagement.entity;

import com.example.membermanagement.global.exception.ErrorCode;
import com.example.membermanagement.global.exception.ServiceException;

public enum MBTI {
    INFP, INFJ, ISFP, ISFJ, INTP, INTJ, ISTP, ISTJ,
    ENFP, ENFJ, ESFP, ESFJ, ENTP, ENTJ, ESTP, ESTJ;

    public static MBTI from(String mbti){
        if (mbti == null || mbti.isBlank()){
            throw new ServiceException(ErrorCode.INVALID_INPUT);
        }

        for (MBTI m : MBTI.values()){
            if (MBTI.valueOf(mbti) == m) return m;
        }
        throw new ServiceException(ErrorCode.INVALID_INPUT);
    }
}
