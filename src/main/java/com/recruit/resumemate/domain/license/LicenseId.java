package com.recruit.resumemate.domain.license;

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
public class LicenseId implements Serializable {
    private Resume resume;
    private String liName;
}
