package com.recruit.recruitmate.config.auth.dto;

import com.recruit.recruitmate.domain.member.Member;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionMember implements Serializable {
    private String id;

    public SessionMember(String id) {
        this.id = id;
    }
}
