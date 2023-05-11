package com.recruit.configmate.auth.dto;

import com.recruit.commonmate.comcode.enums.GRADE;
import com.recruit.usermate.web.dto.LoginDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.io.Serializable;

@Schema(title = "SessionUser",description = "세션 정보 DTO")
@Getter
public class SessionUser implements Serializable {

    @Schema(title = "유저 번호")
    private Long userId;
    @Schema(title = "등급")
    private GRADE grade;

    public SessionUser(LoginDTO dto) {
        this.userId = dto.getUserId();
        this.grade = dto.getGrade();
    }
}
