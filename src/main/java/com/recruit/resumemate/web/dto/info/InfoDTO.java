package com.recruit.resumemate.web.dto.info;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Schema(title = "InfoDTO", description = "자기소개서 DTO")
@Getter
@NoArgsConstructor
public class InfoDTO {
    @Schema(title = "이력서 번호")
    private Long resumeId;
    @Schema(title = "항목")
    private String ifGubun;
    @Schema(title = "이력서 제목")
    private String ifTitle;
    @Schema(title = "이력서 내용")
    private String ifContent;

    @Builder
    public InfoDTO(Long resumeId, String ifGubun, String ifTitle, String ifContent) {
        this.resumeId = resumeId;
        this.ifGubun = ifGubun;
        this.ifTitle = ifTitle;
        this.ifContent = ifContent;
    }


}
