package com.recruit.commonmate.comcode.enums;

import com.recruit.commonmate.comcode.dto.EnumMapper;

public enum REQUIRES implements EnumMapper {
    EXP_ONE("경력 1년"),
    EXP_TWO("경력 2년"),
    EXP_THREE("경력 3년"),
    EXP_FIVE("경력 5년"),
    EXP_SEVEN("경력 7년"),
    EXP_TEN("경력 10년"),
    COLLEAGE("대졸"),
    JUNIOR("초대졸"),
    HIGHSCHOOL("고졸");

    private String title;

    REQUIRES(String title){
        this.title = title;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getCode() {
        return name();
    }
}
