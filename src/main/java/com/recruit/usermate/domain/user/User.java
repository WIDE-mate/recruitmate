package com.recruit.usermate.domain.user;

import com.recruit.systemmate.enums.Gender;
import com.recruit.systemmate.enums.Grade;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long userId;
    @Column(unique = true)
    private String loginId;
    private String password;
    private String name;
    private Date birth;
    private String tel;
    private String email;
    private String addr;
    private String addrDetail;
    private String zip;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private Grade grade;

    @Builder
    public User(Long userId, String loginId, String password, String name, Date birth, String tel, Grade grade,
                String email, String addr, String addrDetail, String zip, Gender gender) {
        this.userId = userId;
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.birth = birth;
        this.tel = tel;
        this.grade = grade;
        this.email = email;
        this.addr = addr;
        this.addrDetail = addrDetail;
        this.zip = zip;
        this.gender = gender;
    }
}
