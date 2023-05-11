package com.recruit.resumemate.domain.license;

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
@IdClass(LicenseId.class)
public class License implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "resume_id", nullable = false)
    private Resume resume;

    @Id
    private String liName;

    private Integer liNum;
    private LocalDate getDate;
    private String place;

    @Builder

    public License(Resume resume, String liName, Integer liNum, LocalDate getDate, String place) {
        this.resume = resume;
        this.liName = liName;
        this.liNum = liNum;
        this.getDate = getDate;
        this.place = place;
    }
}
