package com.recruit.commonmate.comcode.enums;

import com.recruit.commonmate.comcode.dto.EnumMapper;

public enum STATE implements EnumMapper {
    TEMPORARY("임시저장"),
    STORAGE("등록");

    private final String title;

    STATE(String title){
        this.title = title;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public String getCode() {
        return null;
    }
}
