package com.recruit.resumemate.service.resume;

import com.recruit.commonmate.enums.CODE;
import com.recruit.commonmate.global.GlobalException;
import com.recruit.recruitmate.domain.recruit.RecruitRepository;
import com.recruit.resumemate.domain.resume.ResumeRepository;
import com.recruit.resumemate.web.dto.ResumeDTO;
import com.recruit.resumemate.web.dto.ResumeJoinDTO;
import com.recruit.resumemate.web.dto.ResumeMapper;
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
    private final ResumeMapper resumeMapper;

    // 저장 삭제 시에 동시에 되도록 로직을 해야함
//    @Transactional
//    public ResumeDTO resumeSave(ResumeValidDTO dto) {
//        if (resumeRepository.existsByUserAndRecruit(dto.getUser(), dto.getRecruit()))
//            throw new GlobalException(CODE.RESUME_EXISTS);
//        return resumeMapper.toResumeDTO(resumeRepository.save(dto.toEntity()));
//    }
//
//    @Transactional
//    public ResumeDTO resumeUpdate(ResumeValidDTO dto) {
//        if (!resumeRepository.existsById(dto.getResumeId()))
//            throw new GlobalException(CODE.RESUME_NOT_FOUND);
//        return resumeMapper.toResumeDTO(resumeRepository.save(dto.toEntity()));
//    }

    // 삭제 시에 관련 테이블 모두 삭제된는지 단위테스트 필요
    @Transactional
    public void resumeDelete(Long resumeId){
        if (!resumeRepository.existsById(resumeId))
            throw new GlobalException(CODE.RESUME_NOT_FOUND);
        resumeRepository.deleteById(resumeId);
    }

    // 상세 정보 가져오는걸로 변경해야함
    @Transactional
    public ResumeJoinDTO getResume(Long resumeId){
        return null;
//        return resumeRepository.findById(resumeId)
//                .map(resumeMapper::toResumeDTO)
//                .orElse(null);
    }

    @Transactional
    public List<ResumeDTO> getResumeByUser(Long userId){
        if (!userRepository.existsById(userId))
            throw new GlobalException(CODE.USER_NOT_FOUND);
        return resumeRepository.findAllByUserUserId(userId, Sort.by("creDate").descending());
    }

    @Transactional
    public List<ResumeDTO> getResumeByRecruit(Long recruitId){
        if (!recruitRepository.existsById(recruitId))
            throw new GlobalException(CODE.RECRUIT_NOT_FOUND);
        return resumeRepository.findAllByRecruitRecruitId(recruitId, Sort.by("creDate").descending());
    }

    @Transactional
    public List<ResumeDTO> getAllResume(){
        return resumeRepository.findAllBy(Sort.by("creDate").descending());
    }

}
