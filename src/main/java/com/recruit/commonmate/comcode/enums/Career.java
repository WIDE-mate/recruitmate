package com.recruit.commonmate.comcode.enums;

import com.recruit.commonmate.comcode.dto.EnumMapper;

public enum Career implements EnumMapper {
    NEW("신입"),
    OLD("경력");

    private String title;

    Career(String title){
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
