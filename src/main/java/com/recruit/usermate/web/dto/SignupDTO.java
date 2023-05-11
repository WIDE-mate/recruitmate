package com.recruit.usermate.web.dto;

import com.recruit.commonmate.comcode.enums.GENDER;
import com.recruit.commonmate.comcode.enums.GRADE;
import com.recruit.usermate.domain.user.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Schema(title = "SignupDTO",description = "회원 등록 및 수정 관련 DTO")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignupDTO {

    @Schema(title = "유저번호")
    @With
    private Long userId;

    @Schema(title = "아이디")
    @NotEmpty(message = "아이디는 필수 입력입니다.")
    @Size(max = 255,message = "아이디 저장길이를 초과합니다.")
    private String loginId;

    @Schema(title = "패스워드")
    @NotEmpty(message = "비밀번호는 필수 입력입니다.")
    @Size(max = 255,message = "비밀번호 저장길이를 초과합니다.")
    private String password;

    @Schema(title = "이름")
    @NotEmpty(message = "이름은 필수 입력입니다.")
    @Size(max = 255,message = "이름 저장길이를 초과합니다.")
    private String name;

    @Schema(title = "생년월일")
    @NotNull(message = "생년월일은 필수 입력입니다.")
    private LocalDate birth;

    @Schema(title = "전화번호")
    @NotEmpty(message = "전화번호는 필수 입력입니다.")
    @Size(max = 20,message = "전화번호 저장길이를 초과합니다.")
    @Pattern(regexp = "^(\\d{3,4}-\\d{3,4}-\\d{3,4}|\\d{3,4}-\\d{3,4})$", message = "전화번호 형식이 올바르지 않습니다.")
    private String tel;

    @Schema(title = "이메일")
    @Email(message = "이메일 형식을 지켜주세요.")
    @Size(max = 255,message = "이메일 저장길이를 초과합니다.")
    private String email;

    @Schema(title = "주소")
    private String addr;
    @Schema(title = "상세주소")
    private String addrDetail;
    @Schema(title = "우편번호")
    private String zip;

    @Schema(title = "성별")
    @NotNull(message = "성별은 필수 입력입니다.")
    private GENDER gender;

    @Schema(title = "등급")
    private GRADE grade;
    @Schema(title = "로그인키")
    private String loginKey;

    @Builder
    public SignupDTO(Long userId, String loginId, String password, String name, LocalDate birth, String tel, String loginKey,
            String email, String addr, String addrDetail, String zip, GENDER gender, GRADE grade) {
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
                .name(name).birth(birth).tel(tel).email(email).addr(addr).addrDetail(addrDetail).zip(zip)
                .gender(gender).grade(grade).build();
    }

    public User toEntity(String pw){
        return User.builder().userId(userId).loginId(loginId).password(pw)
                .name(name).birth(birth).tel(tel).email(email).addr(addr).addrDetail(addrDetail).zip(zip)
                .gender(gender).grade(GRADE.MEMBER).build();
    }

    public User toEntity(Long id, String lid, String pw, GRADE gd){
        return User.builder().userId(id).loginId(lid).password(pw)
                .name(name).birth(birth).tel(tel).email(email).addr(addr).addrDetail(addrDetail).zip(zip)
                .gender(gender).grade(gd).build();

    }

}
