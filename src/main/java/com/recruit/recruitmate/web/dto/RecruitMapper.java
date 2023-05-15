package com.recruit.recruitmate.web.dto;

import com.recruit.recruitmate.domain.recruit.Recruit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RecruitMapper {

    RecruitMapper INSTANCE = Mappers.getMapper(RecruitMapper.class);

    // Entity to Dto

    @Mapping(target = "recruitId", source = "recruitId")
    @Mapping(target = "reTitle", source = "reTitle")
    @Mapping(target = "reContent", source = "reContent")
    @Mapping(target = "period", source = "period")
    @Mapping(target = "requires", source = "requires")
    @Mapping(target = "task", source = "task")
    @Mapping(target = "career", source = "career")
    RecruitDTO toRecruitDTO(Recruit recruit);

    // Dto to Entity

    @Mapping(target = "recruitId", source = "recruitId")
    @Mapping(target = "reTitle", source = "reTitle")
    @Mapping(target = "reContent", source = "reContent")
    @Mapping(target = "period", source = "period")
    @Mapping(target = "requires", source = "requires")
    @Mapping(target = "task", source = "task")
    @Mapping(target = "career", source = "career")
    @Mapping(target = "resumes", ignore = true)
    Recruit toEntity(RecruitValidDTO recruit);


}
