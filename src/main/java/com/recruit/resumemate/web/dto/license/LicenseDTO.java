package com.recruit.resumemate.web.dto.license;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Schema(title = "LicenseDTO", description = "자격증 DTO")
@Getter
@NoArgsConstructor
public class LicenseDTO {
    @Schema(title = "이력서 번호")
    private Long resumeId;
    @Schema(title = "자격증명")
    private String liName;
    @Schema(title = "자격증 번호")
    private Integer liNum;
    @Schema(title = "취득 일자")
    private LocalDate getDate;
    @Schema(title = "발행처")
    private String place;

    @Builder
    public LicenseDTO(Long resumeId, String liName, Integer liNum, LocalDate getDate, String place) {
        this.resumeId = resumeId;
        this.liName = liName;
        this.liNum = liNum;
        this.getDate = getDate;
        this.place = place;
    }

}
