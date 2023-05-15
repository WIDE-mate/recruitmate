package com.recruit.resumemate.web.dto.info;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Schema(title = "InfoValidDTO", description = "자기소개서 DTO")
@Getter
@NoArgsConstructor
public class InfoValidDTO {
    @Schema(title = "이력서 번호")
    private Long resumeId;
    @NotEmpty(message = "이력서 항목은 필수 입니다.")
    @Schema(title = "항목", required = true)
    private String ifGubun;
    @Schema(title = "이력서 제목")
    private String ifTitle;
    @Schema(title = "이력서 내용")
    private String ifContent;

    @Builder
    public InfoValidDTO(Long resumeId, String ifGubun, String ifTitle, String ifContent) {
        this.resumeId = resumeId;
        this.ifGubun = ifGubun;
        this.ifTitle = ifTitle;
        this.ifContent = ifContent;
    }


}
