package com.recruit.recruitmate.web.dto;

import com.recruit.recruitmate.domain.member.Member;
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

    public Member toEntity(){
        return Member.builder().id(id).password(password).build();
    }
}
