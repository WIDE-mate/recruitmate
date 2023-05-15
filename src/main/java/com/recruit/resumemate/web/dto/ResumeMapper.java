package com.recruit.resumemate.web.dto;

import com.recruit.resumemate.domain.resume.Resume;
import com.recruit.resumemate.web.dto.resume.ResumeJoinDTO;
import com.recruit.resumemate.web.dto.resume.ResumeValidDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ResumeMapper {

    ResumeMapper INSTANCE = Mappers.getMapper(ResumeMapper.class);

    // entity to dto

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
    @Mapping(source = "educations", target = "educations")
    @Mapping(source = "activities", target = "activities")
    @Mapping(source = "licenses", target = "licenses")
    @Mapping(source = "info", target = "info")
    ResumeJoinDTO toResumeJoinDTO(Resume resume);

    // dto to entity

    @Mapping(source = "resumeId", target = "resumeId")
    @Mapping(source = "userId", target = "user.userId")
    @Mapping(source = "recruitId", target = "recruit.recruitId")
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
    @Mapping(ignore = true, target = "educations")
    @Mapping(ignore = true, target = "activities")
    @Mapping(ignore = true, target = "licenses")
    @Mapping(ignore = true, target = "info")
//    @Mapping(source = "educations", target = "educations")
//    @Mapping(source = "activities", target = "activities")
//    @Mapping(source = "licenses", target = "licenses")
//    @Mapping(source = "info", target = "info")
    Resume toEntity(ResumeValidDTO dto);

}
