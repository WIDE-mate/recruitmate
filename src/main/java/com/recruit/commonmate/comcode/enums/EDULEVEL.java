package com.recruit.commonmate.comcode.enums;

import com.recruit.commonmate.comcode.dto.EnumMapper;

public enum EDULEVEL implements EnumMapper {
    HIGH("고등학교"),
    JUNIOR("전문대"),
    UNIV("대학교"),
    GRADUATE("대학원");

    private String title;

    EDULEVEL(String title) {
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
