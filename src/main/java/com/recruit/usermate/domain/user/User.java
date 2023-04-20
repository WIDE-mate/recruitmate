package com.recruit.usermate.domain.user;

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
    private String loginId;
    private String password;
    private String name;
    private Date birth;
    @Column(length =  20)
    private String tel;
    private String email;
    private String addr;
    private String addrDetail;
    private String zip;
    @Column(length = 10, nullable = false)
//    @Enumerated(EnumType.STRING)
    private String grade;

    @Builder
    public User(Long userId, String loginId, String password, String name, Date birth, String tel, String grade, String email, String addr, String addrDetail, String zip) {
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
    }
}
