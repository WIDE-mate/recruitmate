package com.recruit.commonmate.enums;

import com.recruit.commonmate.dto.EnumMapper;

public enum Task implements EnumMapper{
    JOB("직무");

    private String title;

    Task(String  title){
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
