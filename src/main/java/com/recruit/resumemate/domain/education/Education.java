package com.recruit.resumemate.domain.education;

import com.recruit.commonmate.comcode.enums.EDULEVEL;
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
@IdClass(EducationId.class)
public class Education implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "resume_id", nullable = false)
    private Resume resume;

    @Id
    @Enumerated(EnumType.STRING)
    private EDULEVEL eduLevel;

    private String edName;
    private LocalDate enDate;
    private LocalDate graDate;
    private float credit;
    private String major;
    private String thesis;

    @Builder
    public Education(Resume resume, EDULEVEL eduLevel, String edName, LocalDate enDate, LocalDate graDate, float credit, String major, String thesis) {
        this.resume = resume;
        this.eduLevel = eduLevel;
        this.edName = edName;
        this.enDate = enDate;
        this.graDate = graDate;
        this.credit = credit;
        this.major = major;
        this.thesis = thesis;
    }
}
