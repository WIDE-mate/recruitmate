package com.recruit.usermate.web.dto;

import com.recruit.commonmate.enums.Grade;
import com.recruit.usermate.domain.user.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Schema(description = "로그인 요청 DTO")
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
    private Grade grade;

    @Builder
    public LoginDTO(Long userId, String loginId, String password, Grade grade) {
        this.userId = userId;
        this.loginId = loginId;
        this.password = password;
        this.grade = grade;
    }

    public User toEntity(){
        return User.builder().userId(userId).loginId(loginId).password(password)
                .grade(grade).build();
    }
}
