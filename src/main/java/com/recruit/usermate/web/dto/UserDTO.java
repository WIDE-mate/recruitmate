package com.recruit.usermate.web.dto;

import com.recruit.usermate.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Getter
@NoArgsConstructor
public class UserDTO {

    private Long userId;
    private String loginId;
    private String password;
    private String name;
    private Date birth;
    private String tel;
    private String email;
    private String addr;
    private String addrDetail;
    private String zip;
    private String gender;
    private String grade;

    @Builder
    public UserDTO(Long userId, String loginId, String password, String name, Date birth, String tel,
                   String email, String addr, String addrDetail, String zip, String gender, String grade) {
        this.userId = userId;
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.birth = birth;
        this.tel = tel;
        this.email = email;
        this.addr = addr;
        this.addrDetail = addrDetail;
        this.zip = zip;
        this.gender = gender;
        this.grade = grade;
    }


    public User toEntity(){
        return User.builder().loginId(loginId).password(password)
                .name(name).birth(birth).tel(tel).email(email).addr(addr).addrDetail(addrDetail).zip(zip)
                .gender(gender).grade(grade).build();
    }

}
