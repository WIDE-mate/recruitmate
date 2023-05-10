package com.recruit.recruitmate.web.dto;

import com.recruit.recruitmate.domain.recruit.Recruit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface RecruitMapper {

    RecruitMapper INSTANCE = Mappers.getMapper(RecruitMapper.class);

    @Mapping(target = "recruitId", source = "recruitId")
    @Mapping(target = "reTitle", source = "reTitle")
    @Mapping(target = "reContent", source = "reContent")
    @Mapping(target = "period", source = "period")
    @Mapping(target = "requires", source = "requires")
    @Mapping(target = "task", source = "task")
    RecruitDTO toRecruitDTO(Recruit recruit);

}
