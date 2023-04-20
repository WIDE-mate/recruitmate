package com.recruit.usermate.web.dto;

import com.recruit.systemmate.util.BcryptEncoder;
import com.recruit.usermate.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginDTO {

    private Long userId;
    private String loginId;
    private String password;
    private String grade;

    @Builder
    public LoginDTO(Long userId, String loginId, String password, String grade) {
        this.userId = userId;
        this.loginId = loginId;
        this.password = password;
        this.grade = grade;
    }

    public User toEntity(){
        return User.builder().userId(userId).loginId(loginId).password(BcryptEncoder.encode(password))
                .grade(grade).build();
    }
}
