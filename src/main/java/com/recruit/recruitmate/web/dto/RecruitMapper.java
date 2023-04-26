package com.recruit.recruitmate.web.dto;

import com.recruit.recruitmate.domain.recruit.Recruit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface RecruitMapper {

    RecruitMapper INSTANCE = Mappers.getMapper(RecruitMapper.class);

    @Mapping(source = "recruitId",target = "recruitId")
    @Mapping(source = "reTitle",target = "reTitle")
    @Mapping(source = "reContent",target = "reContent")
    @Mapping(source = "period",target = "period")
    @Mapping(source = "requires",target = "requires")
    @Mapping(source = "task",target = "task")
    Recruit toRecruitDTO(RecruitDTO dto);

    @Mapping(source = "recruitId",target = "recruitId")
    @Mapping(source = "reTitle",target = "reTitle")
    @Mapping(source = "reContent",target = "reContent")
    @Mapping(source = "period",target = "period")
    @Mapping(source = "requires",target = "requires")
    @Mapping(source = "task",target = "task")
    RecruitDTO toRecruit(Recruit recruit);

}
