package com.recruit.systemmate.config.auth.dto;

import com.recruit.usermate.web.dto.LoginDTO;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {

    private String id;
    private String grade;

    public SessionUser(LoginDTO dto) {
        this.id = dto.getId();
//        this.grade = dto.getGrade();
    }
}
