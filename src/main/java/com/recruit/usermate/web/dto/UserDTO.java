package com.recruit.usermate.web.dto;

import com.recruit.usermate.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Getter
@NoArgsConstructor
public class UserDTO {

    private String id;
    private String password;
    private String name;
    private Date birth;
    private String tel;

    @Builder
    public UserDTO(String id, String password, String name, Date birth, String tel) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.birth = birth;
        this.tel = tel;
    }

    public User toEntity(){
        return User.builder().id(id).password(password).name(name).birth(birth).tel(tel).build();
    }

}
