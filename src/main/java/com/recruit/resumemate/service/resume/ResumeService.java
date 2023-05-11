package com.recruit.resumemate.service.resume;

import com.recruit.commonmate.enums.CODE;
import com.recruit.commonmate.global.GlobalException;
import com.recruit.resumemate.domain.resume.ResumeRepository;
import com.recruit.resumemate.web.dto.ResumeDTO;
import com.recruit.resumemate.web.dto.ResumeMapper;
import com.recruit.resumemate.web.dto.ResumeValidDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.plaf.PanelUI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ResumeService {

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

    // 삭세 정보 가져오는걸로 변경해야함
    @Transactional
    public ResumeDTO getResume(Long resumeId){
        return resumeRepository.findById(resumeId)
                .map(resumeMapper::toResumeDTO)
                .orElse(null);
    }

    //본인 이력서 => 보안이 필요하니 User에서?

    @Transactional
    public List<ResumeDTO> getAllResuem(){
        return resumeRepository.findAll().stream()
                .map(resumeMapper::toResumeDTO)
                .collect(Collectors.toList());
    }

}
