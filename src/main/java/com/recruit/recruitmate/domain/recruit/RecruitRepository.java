package com.recruit.recruitmate.domain.recruit;

import com.recruit.commonmate.comcode.enums.CAREER;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface RecruitRepository extends JpaRepository<Recruit,Long> {
    Long countByCareerAndPeriodGreaterThanEqual(CAREER career, LocalDate period);
}
