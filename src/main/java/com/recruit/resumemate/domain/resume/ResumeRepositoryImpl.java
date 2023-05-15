package com.recruit.resumemate.domain.resume;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import static com.recruit.resumemate.domain.resume.QResume.resume;
import static com.recruit.resumemate.domain.activity.QActivity.activity;
import static com.recruit.resumemate.domain.education.QEducation.education;
import static com.recruit.resumemate.domain.info.QInfo.info;
import static com.recruit.resumemate.domain.license.QLicense.license;

@RequiredArgsConstructor
public class ResumeRepositoryImpl implements ResumeRepositoryCustom{

    private final JPAQueryFactory factory;

    @Override
    public Resume findJoinById(Long resumeId) {
        return factory.selectFrom(resume)
                .leftJoin(resume.activities, activity)
                .leftJoin(resume.educations, education)
                .leftJoin(resume.info, info)
                .leftJoin(resume.licenses, license)
                .where(resume.resumeId.eq(resumeId))
                .fetchOne();
    }
}
