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
    @Column(length = 20, nullable = false, name = "user_id")
    private int userId;
    @Column
    private String id;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private Date birth;
    @Column(length =  20)
    private String tel;
    @Column(length = 10, nullable = false)
//    @Enumerated(EnumType.STRING)
    private String grade;

    @Builder
    public User(int userId, String id, String password, String name, Date birth, String tel, String grade) {
        this.userId = userId;
        this.id = id;
        this.password = password;
        this.name = name;
        this.birth = birth;
        this.tel = tel;
        this.grade = grade;
    }

}
