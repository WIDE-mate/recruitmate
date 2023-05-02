package com.recruit.usermate.web.dto;

import com.recruit.systemmate.enums.Gender;
import com.recruit.systemmate.enums.Grade;
import com.recruit.usermate.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.sql.Date;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class SignupDTO {

    private Long userId;

    @NotEmpty(message = "아이디는 필수 입력입니다.")
    @Size(max = 255,message = "아이디 저장길이를 초과합니다.")
    private String loginId;

    @NotEmpty(message = "비밀번호는 필수 입력입니다.")
    @Size(max = 255,message = "비밀번호 저장길이를 초과합니다.")
    private String password;

    @NotEmpty(message = "이름은 필수 입력입니다.")
    @Size(max = 255,message = "이름 저장길이를 초과합니다.")
    private String name;

    @NotNull(message = "생년월일은 필수 입력입니다.")
    private LocalDate birth;

    @NotEmpty(message = "전화번호는 필수 입력입니다.")
    @Size(max = 20,message = "전화번호 저장길이를 초과합니다.")
    @Pattern(regexp = "^(\\d{3,4}-\\d{3,4}-\\d{3,4}|\\d{3,4}-\\d{3,4})$", message = "전화번호 형식이 올바르지 않습니다.")
    private String tel;

    @Email(message = "이메일 형식을 지켜주세요.")
    @Size(max = 255,message = "이메일 저장길이를 초과합니다.")
    private String email;

    private String addr;
    private String addrDetail;
    private String zip;

    @NotNull(message = "성별은 필수 입력입니다.")
    private Gender gender;

    private Grade grade;

    private String loginKey;

    @Builder
    public SignupDTO(Long userId, String loginId, String password, String name, LocalDate birth, String tel, String loginKey,
                    String email, String addr, String addrDetail, String zip, Gender gender, Grade grade) {
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
        this.loginKey = loginKey;
    }

    public User toEntity(){
        return User.builder().userId(userId).loginId(loginId).password(password)
                .name(name).birth(Date.valueOf(birth)).tel(tel).email(email).addr(addr).addrDetail(addrDetail).zip(zip)
                .gender(gender).grade(grade).build();
    }

    public User toEntity(String pw){
        return User.builder().userId(userId).loginId(loginId).password(pw)
                .name(name).birth(Date.valueOf(birth)).tel(tel).email(email).addr(addr).addrDetail(addrDetail).zip(zip)
                .gender(gender).grade(Grade.MEMBER).build();
    }

    public User toEntity(Long id, String lid, String pw, Grade gd){
        return User.builder().userId(id).loginId(lid).password(pw)
                .name(name).birth(Date.valueOf(birth)).tel(tel).email(email).addr(addr).addrDetail(addrDetail).zip(zip)
                .gender(gender).grade(gd).build();

    }

}
