package com.recruit.usermate.web.dto;

import com.recruit.usermate.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginDTO {

    private int userId;
    private String id;
    private String password;
    private String grade;

    @Builder
    public LoginDTO(int userId, String id, String password, String grade) {
        this.userId = userId;
        this.id = id;
        this.password = password;
        this.grade = grade;
    }

    public User toEntity(){
        return User.builder().userId(userId).id(id).password(password).grade(grade).build();
    }
}
