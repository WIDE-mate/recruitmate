package com.recruit.systemmate.enums;

import com.recruit.systemmate.config.em.dto.EnumMapper;

public enum Gender implements EnumMapper {
    F("여자"),
    M("남자");

    private String title;

    Gender(String title){
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
