package com.recruit.usermate.web.dto;

import com.recruit.usermate.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginDTO {

    private String id;
    private String password;

    @Builder
    public LoginDTO(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public User toEntity(){
        return User.builder().id(id).password(password).build();
    }
}
