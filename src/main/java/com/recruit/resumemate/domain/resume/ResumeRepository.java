package com.recruit.resumemate.domain.resume;

import com.recruit.resumemate.web.dto.resume.ResumeDTO;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResumeRepository extends JpaRepository<Resume,Long>, ResumeRepositoryCustom{
    List<ResumeDTO> findAllByUserUserId(Long userId, Sort sort);
    List<ResumeDTO> findAllByRecruitRecruitId(Long recruitId, Sort sort);
    List<ResumeDTO> findAllBy(Sort sort);
}
