package com.recruit.recruitmate.web.dto;

import com.recruit.commonmate.enums.Task;
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

    private Long recruitId;
    private String reTitle;
    private String reContent;
    private LocalDate period;
    private String requires;
    private Task task;

    @Builder
    public RecruitDTO(Long recruitId, String reTitle, String reContent, LocalDate period, String requires, Task task) {
        this.recruitId = recruitId;
        this.reTitle = reTitle;
        this.reContent = reContent;
        this.period = period;
        this.requires = requires;
        this.task = task;
    }

    public Recruit toEntity(){
        return Recruit.builder().recruitId(recruitId).reTitle(reTitle).reContent(reContent)
                .period(period).requires(requires).task(task).build();
    }

}
