package com.recruit.recruitmate.domain.recruit;

import com.recruit.commonmate.comcode.enums.CAREER;
import com.recruit.recruitmate.web.dto.RecruitDTO;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RecruitRepository extends JpaRepository<Recruit,Long> {
    List<RecruitDTO> findAllBy(Sort sort);
    Long countByCareerAndPeriodGreaterThanEqual(CAREER career, LocalDate period);
}
