package com.recruit.usermate.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int userId;
    private String id;
    private String password;
    private String name;
    private Date birth;
    @Column(length =  20)
    private String tel;
    @Column(length = 10, nullable = false)
//    @Enumerated(EnumType.STRING)
    private String grade;
    private String email;
    private String addr;
    private String addrDetail;
    private String zip;

    @Builder
    public User(int userId, String id, String password, String name, Date birth, String tel, String grade, String email, String addr, String addrDetail, String zip) {
        this.userId = userId;
        this.id = id;
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
