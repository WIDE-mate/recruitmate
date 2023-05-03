package com.recruit.commonmate.dto;

import lombok.Getter;

@Getter
public class EnumDTO {
    private String title;
    private String code;

    public EnumDTO(EnumMapper enumMapper){
        this.title = enumMapper.getTitle();
        this.code = enumMapper.getCode();
    }

    @Override
    public String toString() {
        return "{ title = '" + this.title + "', code = '" + this.code + "'}";
    }
}
