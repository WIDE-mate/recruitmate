package com.recruit.recruitmate.domain.recruit;

import com.recruit.commonmate.enums.Task;
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
    private String requires;
    @Enumerated(EnumType.STRING)
    private Task task;

    @Builder
    public Recruit(Long recruitId, String reTitle, String reContent, LocalDate period, String requires, Task task) {
        this.recruitId = recruitId;
        this.reTitle = reTitle;
        this.reContent = reContent;
        this.period = period;
        this.requires = requires;
        this.task = task;
    }
}
