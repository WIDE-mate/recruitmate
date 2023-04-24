package com.recruit.recruitmate.domain.recruit;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Getter
@NoArgsConstructor
@Entity
public class Recruit {
    @Id
    private Long recruitId;
    private String reTitle;
    private String reContent;
    private Date period;
    private String requires;
    private String task;

    @Builder
    public Recruit(Long recruitId, String reTitle, String reContent, Date period, String requires, String task) {
        this.recruitId = recruitId;
        this.reTitle = reTitle;
        this.reContent = reContent;
        this.period = period;
        this.requires = requires;
        this.task = task;
    }
}
