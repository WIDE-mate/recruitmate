package com.recruit.resumemate.web.dto.activity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Schema(title = "ActivityValidDTO", description = "대외활동 유효성 검사 DTO")
@Getter
@NoArgsConstructor
public class ActivityValidDTO {
    @Schema(title = "이력서 번호")
    private Long resumeId;
    @NotEmpty(message = "활동명은 필수 입니다.")
    @Schema(title = "활동명", required = true)
    private String acName;
    @Schema(title = "회사/기간/단체명")
    private String company;
    @Schema(title = "활동내용")
    private String acContent;
    @Schema(title = "시작 일자")
    private LocalDate startDate;
    @Schema(title = "종료 일자")
    private LocalDate endDate;

    @Builder
    public ActivityValidDTO(Long resumeId, String acName, String company, String acContent, LocalDate startDate, LocalDate endDate) {
        this.resumeId = resumeId;
        this.acName = acName;
        this.company = company;
        this.acContent = acContent;
        this.startDate = startDate;
        this.endDate = endDate;
    }

}
