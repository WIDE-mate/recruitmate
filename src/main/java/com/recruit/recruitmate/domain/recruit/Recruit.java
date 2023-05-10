package com.recruit.recruitmate.domain.recruit;

import com.recruit.commonmate.enums.Career;
import com.recruit.commonmate.enums.Requires;
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
    @Enumerated(EnumType.STRING)
    private Requires requires;
    @Enumerated(EnumType.STRING)
    private Task task;
    @Enumerated(EnumType.STRING)
    private Career career;

    @Builder
    public Recruit(Long recruitId, String reTitle, String reContent, LocalDate period,
                Requires requires, Task task, Career career) {
        this.recruitId = recruitId;
        this.reTitle = reTitle;
        this.reContent = reContent;
        this.period = period;
        this.requires = requires;
        this.task = task;
        this.career = career;
    }
}
