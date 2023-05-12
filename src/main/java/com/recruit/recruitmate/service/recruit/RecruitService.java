package com.recruit.recruitmate.service.recruit;

import com.recruit.commonmate.comcode.enums.CAREER;
import com.recruit.commonmate.enums.CODE;
import com.recruit.commonmate.global.GlobalException;
import com.recruit.recruitmate.domain.recruit.RecruitRepository;
import com.recruit.recruitmate.web.dto.RecruitDTO;
import com.recruit.recruitmate.web.dto.RecruitMapper;
import com.recruit.recruitmate.web.dto.RecruitValidDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RecruitService {

    private final RecruitRepository recruitRepository;
    private final RecruitMapper recruitMapper;

    @Transactional
    public RecruitDTO recruitSave(RecruitValidDTO dto){
        return recruitMapper.toRecruitDTO(recruitRepository.save(dto.toEntity()));
    }

    @Transactional
    public RecruitDTO recruitUpdate(RecruitValidDTO dto){
        if (!recruitRepository.existsById(dto.getRecruitId()))
            throw new GlobalException(CODE.RECRUIT_NOT_FOUND);
        return recruitMapper.toRecruitDTO(recruitRepository.save(dto.toEntity()));
    }

    @Transactional
    public void recruitDelete(Long id){
        if (!recruitRepository.existsById(id))
            throw new GlobalException(CODE.RECRUIT_NOT_FOUND);
        recruitRepository.deleteById(id);
    }

    @Transactional
    public RecruitDTO getRecruit(Long id){
        return recruitRepository.findById(id)
                .map(recruitMapper::toRecruitDTO)
                .orElse(null);
    }

    @Transactional
    public List<RecruitDTO> getAllRecruit(){
        return recruitRepository.findAllBy(Sort.by("period").descending());
    }

    @Transactional
    public Map<String,Long> cntCareer(LocalDate date){
        return Arrays.stream(CAREER.values())
                .collect(Collectors.toMap(CAREER::getTitle,
                        career ->
                            recruitRepository.countByCareerAndPeriodGreaterThanEqual(career,date)));
    }

}
