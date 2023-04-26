package com.recruit.recruitmate.service.recruit;

import com.recruit.recruitmate.domain.recruit.RecruitRepository;
import com.recruit.recruitmate.web.dto.RecruitDTO;
import com.recruit.recruitmate.web.dto.RecruitMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class RecruitService {

    private final RecruitRepository recruitRepository;
    private final RecruitMapper recruitMapper;

    @Transactional
    public void recruitSave(RecruitDTO dto){
        // 예외처리
        recruitRepository.save(recruitMapper.toRecruitDTO(dto));
    }

    @Transactional
    public RecruitDTO getRecruit(String id){
        // 예외처리
        return null;
//        return recruitMapper.toRecruit(recruitRepository.findById(id));
    }

}
