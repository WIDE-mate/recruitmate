package com.recruit.systemmate.enums;

import lombok.Getter;

@Getter
public enum ERROR {
    ERROR("에러"),
    NOT_FOUND("NOT_FOUND"),
    UNKNOWN("알수없음"),

    DUPLICATE_ID("아이디_중복"),
    DB_ERR("DB_에러"),
    ERR_SESSION("세션_에러"),
    
    NOT_EMPTY("필수값_누락"),
    MAX_VALUE("저장값_초과"),
    PATTERN("형식_에러"),
    EMAIL("이메일_형식_에러");

    private String title;

    ERROR(String title){
        this.title = title;
    }
}
