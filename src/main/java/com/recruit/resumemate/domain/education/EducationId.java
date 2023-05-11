package com.recruit.resumemate.domain.education;

import com.recruit.commonmate.comcode.enums.EDULEVEL;
import com.recruit.resumemate.domain.resume.Resume;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@EqualsAndHashCode
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EducationId implements Serializable {
    private Resume resume;
    private EDULEVEL eduLevel;
}
