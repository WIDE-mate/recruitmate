package com.recruit.systemmate.config.auth.dto;

import com.recruit.systemmate.enums.Grade;
import com.recruit.usermate.web.dto.LoginDTO;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {

    private Long userId;
    private Grade grade;

    public SessionUser(LoginDTO dto) {
        this.userId = dto.getUserId();
        this.grade = dto.getGrade();
    }
}
