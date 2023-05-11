package com.recruit.recruitmate.domain.recruit;

import com.recruit.commonmate.comcode.enums.CAREER;
import com.recruit.commonmate.comcode.enums.REQUIRES;
import com.recruit.commonmate.comcode.enums.TASK;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity
public class Recruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recruitId;
    private String reTitle;
    private String reContent;
    private LocalDate period;
    @Enumerated(EnumType.STRING)
    private REQUIRES requires;
    @Enumerated(EnumType.STRING)
    private TASK task;
    @Enumerated(EnumType.STRING)
    private CAREER career;

    @Builder
    public Recruit(Long recruitId, String reTitle, String reContent, LocalDate period,
                   REQUIRES requires, TASK task, CAREER career) {
        this.recruitId = recruitId;
        this.reTitle = reTitle;
        this.reContent = reContent;
        this.period = period;
        this.requires = requires;
        this.task = task;
        this.career = career;
    }
}
