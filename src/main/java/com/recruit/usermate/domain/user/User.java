package com.recruit.usermate.domain.user;

import com.recruit.commonmate.comcode.enums.GENDER;
import com.recruit.commonmate.comcode.enums.GRADE;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

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
    private LocalDate birth;
    private String tel;
    private String email;
    private String addr;
    private String addrDetail;
    private String zip;
    @Enumerated(EnumType.STRING)
    private GENDER gender;
    @Enumerated(EnumType.STRING)
    private GRADE grade;

    @Builder
    public User(Long userId, String loginId, String password, String name, LocalDate birth, String tel, GRADE grade,
                String email, String addr, String addrDetail, String zip, GENDER gender) {
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
