package com.recruit.recruitmate.web.dto;

import com.recruit.commonmate.comcode.enums.Career;
import com.recruit.commonmate.comcode.enums.Requires;
import com.recruit.commonmate.comcode.enums.Task;
import com.recruit.recruitmate.domain.recruit.Recruit;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Schema(title = "RecruitDTO", description = "채용 정보 DTO")
@Getter
@NoArgsConstructor
public class RecruitDTO {

    @Schema(title = "채용 번호")
    private Long recruitId;
    @Schema(title = "제목")
    private String reTitle;
    @Schema(title = "내용")
    private String reContent;
    @Schema(title = "기간")
    private LocalDate period;
    @Schema(title = "지원조건")
    private Requires requires;
    @Schema(title = "직무")
    private Task task;
    @Schema(title = "채용구분")
    private Career career;

    @Builder
    public RecruitDTO(Long recruitId, String reTitle, String reContent, LocalDate period,
                    Requires requires, Task task, Career career) {
        this.recruitId = recruitId;
        this.reTitle = reTitle;
        this.reContent = reContent;
        this.period = period;
        this.requires = requires;
        this.task = task;
        this.career = career;
    }

    public Recruit toEntity(){
        return Recruit.builder().recruitId(recruitId).reTitle(reTitle).reContent(reContent)
                .period(period).requires(requires).task(task).career(career).build();
    }

}
