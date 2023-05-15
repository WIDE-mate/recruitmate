package com.recruit.resumemate.web.dto.resume;

import com.recruit.commonmate.comcode.enums.GENDER;
import com.recruit.commonmate.comcode.enums.STATE;
import com.recruit.commonmate.enums.CHECK;
import com.recruit.resumemate.web.dto.activity.ActivityDTO;
import com.recruit.resumemate.web.dto.education.EducationDTO;
import com.recruit.resumemate.web.dto.info.InfoDTO;
import com.recruit.resumemate.web.dto.license.LicenseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Schema(title = "ResumeJoinDTO" , description = "이력서 및 상세정보 DTO")
@Getter
@NoArgsConstructor
public class ResumeJoinDTO {

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
    @Schema(title = "교육")
    private List<EducationDTO> educations;
    @Schema(title = "대외활동")
    private List<ActivityDTO> activities;
    @Schema(title = "자격증")
    private List<LicenseDTO> licenses;
    @Schema(title = "자기소개서")
    private List<InfoDTO> info;

    @Builder
    public ResumeJoinDTO(Long resumeId, Long userId, Long recruitId, GENDER gender, String engName, String email,
            String addr, String addrDetail, String zip, CHECK military, String pic, LocalDate creDate, STATE state,
            List<EducationDTO> educations, List<ActivityDTO> activities, List<LicenseDTO> licenses, List<InfoDTO> info) {
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
