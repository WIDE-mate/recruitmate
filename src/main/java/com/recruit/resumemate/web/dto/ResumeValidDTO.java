package com.recruit.resumemate.web.dto;

import com.recruit.commonmate.comcode.enums.GENDER;
import com.recruit.commonmate.comcode.enums.STATE;
import com.recruit.commonmate.enums.CHECK;
import com.recruit.recruitmate.domain.recruit.Recruit;
import com.recruit.resumemate.domain.resume.Resume;
import com.recruit.usermate.domain.user.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Schema(title = "ResumeValidDTO" , description = "이력서 등록 및 수정 관련 DTO")
@Getter
@NoArgsConstructor
public class ResumeValidDTO {

    @Schema(title = "이력서 번호")
    private Long resumeId;

    @Schema(title = "유저 정보")
    @NotNull(message = "유저 정보는 핈수 입니다.")
    private User user;

    @Schema(title = "이력서 정보")
    @NotNull(message = "채용 정보는 핈수 입니다.")
    private Recruit recruit;

    @Schema(title = "성별")
    private GENDER gender;
    @Schema(title = "영어 이름")
    private String engName;
    @Schema(title = "이메일")
    private String email;
    @Schema(title = "주소")
    private String addr;
    @Schema(title = "상세주소")
    private String addrDetail;
    @Schema(title = "우편번호")
    private String zip;
    @Schema(title = "병역여부")
    private CHECK military;
    @Schema(title = "사진")
    private String pic;

    @Schema(title = "작성일자")
    @NotNull(message = "작성 일자는 핈수 입니다.")
    private LocalDate creDate;

    @Schema(title = "등록 상태")
    @NotNull(message = "등록 상태는 핈수 입니다.")
    private STATE state;

    @Builder
    public ResumeValidDTO(Long resumeId, User user, Recruit recruit, GENDER gender, String engName, String email, String addr, String addrDetail, String zip,
                    CHECK military, String pic, LocalDate creDate, STATE state) {
        this.resumeId = resumeId;
        this.user = user;
        this.recruit = recruit;
        this.gender = gender;
        this.engName = engName;
        this.email = email;
        this.addr = addr;
        this.addrDetail = addrDetail;
        this.zip = zip;
        this.military = military;
        this.pic = pic;
        this.creDate = creDate;
        this.state = state;
    }

    public Resume toEntity(){
        return Resume.builder().resumeId(resumeId).user(user).recruit(recruit).gender(gender).engName(engName).email(email)
                .addr(addr).addrDetail(addrDetail).zip(zip).military(military).pic(pic).creDate(creDate).state(state).build();
    }

}
