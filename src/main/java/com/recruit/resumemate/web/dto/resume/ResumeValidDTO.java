package com.recruit.resumemate.web.dto.resume;

import com.recruit.commonmate.comcode.enums.GENDER;
import com.recruit.commonmate.comcode.enums.STATE;
import com.recruit.commonmate.enums.CHECK;
import com.recruit.resumemate.web.dto.info.InfoDTO;
import com.recruit.resumemate.web.dto.info.InfoValidDTO;
import com.recruit.resumemate.web.dto.license.LicenseDTO;
import com.recruit.resumemate.web.dto.activity.ActivityValidDTO;
import com.recruit.resumemate.web.dto.education.EducationValidDTO;
import com.recruit.resumemate.web.dto.license.LicenseValidDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Schema(title = "ResumeValidDTO" , description = "이력서 유효성 검사 DTO")
@Getter
@NoArgsConstructor
public class ResumeValidDTO {

    @Schema(title = "이력서 번호")
    private Long resumeId;

    @Schema(title = "유저 정보", required = true)
    @NotEmpty(message = "유저 정보는 핈수 입니다.")
    private Long userId;

    @Schema(title = "이력서 정보", required = true)
    @NotEmpty(message = "채용 정보는 핈수 입니다.")
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

    @Schema(title = "작성일자", required = true)
    @NotNull(message = "작성 일자는 핈수 입니다.")
    private LocalDate creDate;

    @Schema(title = "등록 상태", required = true)
    @NotNull(message = "등록 상태는 핈수 입니다.")
    private STATE state;

    @Schema(title = "교육")
    private List<EducationValidDTO> educations;
    @Schema(title = "대외활동")
    private List<ActivityValidDTO> activities;
    @Schema(title = "자격증")
    private List<LicenseValidDTO> licenses;
    @Schema(title = "자기소개서")
    private List<InfoValidDTO> info;

    @Builder
    public ResumeValidDTO(Long resumeId, Long userId, Long recruitId, GENDER gender, String engName, String email,
            String addr, String addrDetail, String zip, CHECK military, String pic, LocalDate creDate, STATE state,
            List<EducationValidDTO> educations, List<ActivityValidDTO> activities, List<LicenseValidDTO> licenses, List<InfoValidDTO> info) {
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
        this.educations = educations;
        this.activities = activities;
        this.licenses = licenses;
        this.info = info;
    }

}
