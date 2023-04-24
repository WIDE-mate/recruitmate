package com.recruit.recruitmate.web.dto;

import com.recruit.recruitmate.domain.recruit.Recruit;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Getter
@NoArgsConstructor
public class RecruitDTO {

    private Long recruitId;
    private String reTitle;
    private String reContent;
    private Date period;
    private String requires;
    private String task;

    @Builder
    public RecruitDTO(Long recruitId, String reTitle, String reContent, Date period, String requires, String task) {
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
