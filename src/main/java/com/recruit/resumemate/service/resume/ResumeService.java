package com.recruit.resumemate.service.resume;

import com.recruit.commonmate.enums.CODE;
import com.recruit.commonmate.global.GlobalException;
import com.recruit.recruitmate.domain.recruit.RecruitRepository;
import com.recruit.resumemate.domain.resume.ResumeRepository;
import com.recruit.resumemate.web.dto.ResumeMapper;
import com.recruit.resumemate.web.dto.resume.ResumeDTO;
import com.recruit.resumemate.web.dto.resume.ResumeJoinDTO;
import com.recruit.resumemate.web.dto.resume.ResumeValidDTO;
import com.recruit.usermate.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ResumeService {

    private final UserRepository userRepository;
    private final RecruitRepository recruitRepository;
    private final ResumeRepository resumeRepository;
    private final ResumeMapper resumesMapper;

    @Transactional
    public String resumeSave(ResumeValidDTO dto) {
        chkRecruit(dto.getRecruitId());
        chkResume(dto.getResumeId());
        return resumeRepository.save(resumesMapper.toEntity(dto))
                .getResumeId().toString();
    }

    @Transactional
    public String resumeUpdate(ResumeValidDTO dto) {
        chkUser(dto.getUserId());
        chkRecruit(dto.getRecruitId());
        chkResume(dto.getResumeId());
        return resumeRepository.save(resumesMapper.toEntity(dto))
                .getResumeId().toString();
    }

    // 삭제 시에 관련 테이블 모두 삭제된는지 단위테스트 필요
    @Transactional
    public void resumeDelete(Long resumeId){
        if (!resumeRepository.existsById(resumeId))
            throw new GlobalException(CODE.RESUME_NOT_FOUND);
        resumeRepository.deleteById(resumeId);
    }

    @Transactional
    public ResumeJoinDTO getResumeJoin(Long resumeId){
        return resumesMapper.toResumeJoinDTO(resumeRepository.findJoinById(resumeId));
    }

    @Transactional
    public List<ResumeDTO> getResumeByUser(Long userId){
        chkUser(userId);
        return resumeRepository.findAllByUserUserId(userId, Sort.by("creDate").descending());
    }

    @Transactional
    public List<ResumeDTO> getResumeByRecruit(Long recruitId){
        chkRecruit(recruitId);
        return resumeRepository.findAllByRecruitRecruitId(recruitId, Sort.by("creDate").descending());
    }

    @Transactional
    public List<ResumeDTO> getAllResume(){
        return resumeRepository.findAllBy(Sort.by("creDate").descending());
    }

    private void chkUser(Long id){
        if (!userRepository.existsById(id))
            throw new GlobalException(CODE.USER_NOT_FOUND);
    }

    private void chkRecruit(Long id){
        if (!recruitRepository.existsById(id))
            throw new GlobalException(CODE.RECRUIT_NOT_FOUND);
    }

    private void chkResume(Long id){
        if (!resumeRepository.existsById(id))
            throw new GlobalException(CODE.RESUME_NOT_FOUND);
    }

}
