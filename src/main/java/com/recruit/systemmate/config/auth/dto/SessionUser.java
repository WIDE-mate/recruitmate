package com.recruit.systemmate.config.auth.dto;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String id;

    public SessionUser(String id) {
        this.id = id;
    }
}
