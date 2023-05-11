package com.recruit.resumemate.domain.info;

import com.recruit.resumemate.domain.resume.Resume;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@Entity
@IdClass(InfoId.class)
public class Info implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "resume_id", nullable = false)
    private Resume resume;

    @Id
    private String ifGubun;

    private String ifTitle;
    private String ifContent;

    @Builder
    public Info(Resume resume, String ifGubun, String ifTitle, String ifContent) {
        this.resume = resume;
        this.ifGubun = ifGubun;
        this.ifTitle = ifTitle;
        this.ifContent = ifContent;
    }
}
