package com.recruit.commonmate.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Schema(title = "EnumDTO",description = "공통 코드 DTO")
@Getter
public class EnumDTO {
    @Schema(title = "코드명")
    private String title;
    @Schema(title = "코드내용")
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
