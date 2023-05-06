package com.recruit.usermate.web.dto;

import com.recruit.commonmate.enums.Gender;
import com.recruit.commonmate.enums.Grade;
import com.recruit.usermate.domain.user.User;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Schema(title = "UserDTO",description = "회원 정보 DTO")
@ApiResponse
@Getter
@NoArgsConstructor
public class UserDTO {

    @Schema(title = "유저번호")
    private Long userId;
    @Schema(title = "아이디")
    private String loginId;
    @Schema(title = "패스워드")
    private String password;
    @Schema(title = "이름")
    private String name;
    @Schema(title = "생년월일")
    private LocalDate birth;
    @Schema(title = "전화번호")
    private String tel;
    @Schema(title = "이메일")
    private String email;
    @Schema(title = "주소")
    private String addr;
    @Schema(title = "상세주소")
    private String addrDetail;
    @Schema(title = "우편번호")
    private String zip;
    @Schema(title = "성별")
    private Gender gender;
    @Schema(title = "등급")
    private Grade grade;

    @Builder
    public UserDTO(Long userId, String loginId, String password, String name, LocalDate birth, String tel,
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
    }


    public User toEntity(){
        return User.builder().userId(userId).loginId(loginId).password(password)
                .name(name).birth(birth).tel(tel).email(email).addr(addr).addrDetail(addrDetail).zip(zip)
                .gender(gender).grade(grade).build();
    }

}
