package com.recruit.resumemate.web.dto.license;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Schema(title = "LicenseValidDTO", description = "자격증 유효성 검사 DTO")
@Getter
@NoArgsConstructor
public class LicenseValidDTO {
    @Schema(title = "이력서 번호")
    private Long resumeId;
    @NotEmpty(message = "자격증명은 필수 입니다.")
    @Schema(title = "자격증명", required = true)
    private String liName;
    @Schema(title = "자격증 번호")
    private Integer liNum;
    @Schema(title = "취득 일자")
    private LocalDate getDate;
    @Schema(title = "발행처")
    private String place;

    @Builder
    public LicenseValidDTO(Long resumeId, String liName, Integer liNum, LocalDate getDate, String place) {
        this.resumeId = resumeId;
        this.liName = liName;
        this.liNum = liNum;
        this.getDate = getDate;
        this.place = place;
    }

}
