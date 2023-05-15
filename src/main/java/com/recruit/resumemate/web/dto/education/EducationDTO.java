package com.recruit.resumemate.web.dto.education;

import com.recruit.commonmate.comcode.enums.EDULEVEL;
import com.recruit.resumemate.domain.education.Education;
import com.recruit.resumemate.domain.resume.Resume;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Schema(title = "EducationDTO", description = "교육 DTO")
@Getter
@NoArgsConstructor
public class EducationDTO {
    @Schema(title = "이력서 번호")
    private Long resumeId;
    @Schema(title = "학력구분")
    private EDULEVEL eduLevel;
    @Schema(title = "학교명")
    private String edName;
    @Schema(title = "입학 일자")
    private LocalDate enDate;
    @Schema(title = "졸업 일자")
    private LocalDate graDate;
    @Schema(title = "학점")
    private float credit;
    @Schema(title = "전공")
    private String major;
    @Schema(title = "논문")
    private String thesis;

    @Builder
    public EducationDTO(Long resumeId, EDULEVEL eduLevel, String edName, LocalDate enDate, LocalDate graDate, float credit, String major, String thesis) {
        this.resumeId = resumeId;
        this.eduLevel = eduLevel;
        this.edName = edName;
        this.enDate = enDate;
        this.graDate = graDate;
        this.credit = credit;
        this.major = major;
        this.thesis = thesis;
    }

}
