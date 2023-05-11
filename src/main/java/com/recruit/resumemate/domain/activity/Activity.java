package com.recruit.resumemate.domain.activity;

import com.recruit.resumemate.domain.resume.Resume;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity
@IdClass(ActivityId.class)
public class Activity implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "resume_id", nullable = false)
    private Resume resume;

    @Id
    private String acName;

    private String company;
    private String acContent;
    private LocalDate startDate;
    private LocalDate endDate;

    @Builder
    public Activity(Resume resume, String acName, String company, String acContent, LocalDate startDate, LocalDate endDate) {
        this.resume = resume;
        this.acName = acName;
        this.company = company;
        this.acContent = acContent;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
