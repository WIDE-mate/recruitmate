package com.recruit.resumemate.domain.info;

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
public class InfoId implements Serializable {
    private Resume resume;
    private String ifGubun;
}
