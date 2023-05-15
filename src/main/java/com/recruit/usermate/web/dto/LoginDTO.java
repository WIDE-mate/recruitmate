package com.recruit.usermate.web.dto;

import com.recruit.commonmate.comcode.enums.GRADE;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Schema(title = "LoginDTO",description = "로그인 요청 DTO")
@Getter
@NoArgsConstructor
public class LoginDTO {

    @Schema(title = "유저번호")
    private Long userId;
    @Schema(title = "아이디")
    private String loginId;
    @Schema(title = "패스워드")
    private String password;
    @Schema(title = "등급")
    private GRADE grade;

    @Builder
    public LoginDTO(Long userId, String loginId, String password, GRADE grade) {
        this.userId = userId;
        this.loginId = loginId;
        this.password = password;
        this.grade = grade;
    }

}
