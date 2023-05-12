package com.recruit.resumemate.web.dto;

import com.recruit.resumemate.domain.resume.Resume;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ResumeMapper {

    ResumeMapper INSTANCE = Mappers.getMapper(ResumeMapper.class);

    @Mapping(source = "resumeId", target = "resumeId")
    @Mapping(source = "user.userId", target = "userId")
    @Mapping(source = "recruit.recruitId", target = "recruitId")
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "engName", target = "engName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "addr", target = "addr")
    @Mapping(source = "addrDetail", target = "addrDetail")
    @Mapping(source = "zip", target = "zip")
    @Mapping(source = "military", target = "military")
    @Mapping(source = "pic", target = "pic")
    @Mapping(source = "creDate", target = "creDate")
    @Mapping(source = "state", target = "state")
    ResumeDTO toResumeDTO(Resume resume);

}
