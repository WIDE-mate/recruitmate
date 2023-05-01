package com.recruit.systemmate.enums;

import com.recruit.systemmate.config.em.dto.EnumMapper;

public enum Grade implements EnumMapper {
    NON_MEMBER("비회원"),
    MEMBER("회원"),
    ADMIN("관리자");

    private String title;

    Grade(String title){
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
