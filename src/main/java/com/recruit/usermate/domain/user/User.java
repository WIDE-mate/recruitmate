package com.recruit.usermate.domain.user;

import com.recruit.commonmate.comcode.enums.GENDER;
import com.recruit.commonmate.comcode.enums.GRADE;
import com.recruit.resumemate.domain.resume.Resume;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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

    @OneToMany
    private List<Resume> resumes;

    @Builder
    public User(Long userId, String loginId, String password, String name, LocalDate birth, String tel, GRADE grade,
                String email, String addr, String addrDetail, String zip, GENDER gender, List<Resume> resumes) {
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
        this.resumes = resumes;
    }
}
