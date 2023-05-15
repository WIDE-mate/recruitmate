package com.recruit.resumemate.web.dto.education;

import com.recruit.commonmate.comcode.enums.EDULEVEL;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Schema(title = "EducationValidDTO", description = "교육 유효성 검사 DTO")
@Getter
@NoArgsConstructor
public class EducationValidDTO {
    @Schema(title = "이력서 번호")
    private Long resumeId;
    @NotEmpty(message = "학력구분은 필수 입니다.")
    @Schema(title = "학력구분", required = true)
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
    public EducationValidDTO(Long resumeId, EDULEVEL eduLevel, String edName, LocalDate enDate, LocalDate graDate, float credit, String major, String thesis) {
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
