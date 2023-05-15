package com.recruit.resumemate.web.dto.resume;

import com.recruit.commonmate.comcode.enums.GENDER;
import com.recruit.commonmate.comcode.enums.STATE;
import com.recruit.commonmate.enums.CHECK;
import com.recruit.commonmate.enums.CODE;
import com.recruit.commonmate.global.GlobalException;
import com.recruit.recruitmate.domain.recruit.Recruit;
import com.recruit.recruitmate.domain.recruit.RecruitRepository;
import com.recruit.resumemate.domain.resume.Resume;
import com.recruit.usermate.domain.user.User;
import com.recruit.usermate.domain.user.UserRepository;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;

@Schema(title = "ResumeDTO" , description = "이력서 DTO")
@Getter
@NoArgsConstructor
public class ResumeDTO {

    @Schema(title = "이력서 번호")
    private Long resumeId;
    @Schema(title = "유저 정보")
    private Long userId;
    @Schema(title = "이력서 정보")
    private Long recruitId;
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
    private LocalDate creDate;
    @Schema(title = "등록상태")
    private STATE state;

    @Builder
    public ResumeDTO(Long resumeId, Long userId, Long recruitId, GENDER gender, String engName, String email, String addr, String addrDetail, String zip,
                CHECK military, String pic, LocalDate creDate, STATE state) {
        this.resumeId = resumeId;
        this.userId = userId;
        this.recruitId = recruitId;
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

}
