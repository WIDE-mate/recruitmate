package com.recruit.resumemate.web.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ResumeMapper {

    ResumeMapper INSTANCE = Mappers.getMapper(ResumeMapper.class);
}
