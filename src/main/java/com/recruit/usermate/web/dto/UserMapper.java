package com.recruit.usermate.web.dto;

import com.recruit.usermate.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    // Entity to Dto

    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "loginId",target = "loginId")
    @Mapping(source = "password",target = "password")
    @Mapping(source = "grade",target = "grade")
    LoginDTO toLoginDTO(User user);

    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "loginId", target = "loginId")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "birth", target = "birth")
    @Mapping(source = "tel", target = "tel")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "addr", target = "addr")
    @Mapping(source = "addrDetail", target = "addrDetail")
    @Mapping(source = "zip", target = "zip")
    @Mapping(source = "grade", target = "grade")
    @Mapping(source = "gender", target = "gender")
    UserDTO toUserDTO(User user);

    // Dto to Entity

    @Mapping(source = "dto.userId", target = "userId")
    @Mapping(source = "dto.loginId", target = "loginId")
    @Mapping(source = "encoder", target = "password")
    @Mapping(source = "dto.name", target = "name")
    @Mapping(source = "dto.birth", target = "birth")
    @Mapping(source = "dto.tel", target = "tel")
    @Mapping(source = "dto.email", target = "email")
    @Mapping(source = "dto.addr", target = "addr")
    @Mapping(source = "dto.addrDetail", target = "addrDetail")
    @Mapping(source = "dto.zip", target = "zip")
    @Mapping(source = "dto.gender", target = "gender")
    @Mapping(source = "dto.grade", target = "grade")
    @Mapping(target = "resumes", ignore = true)
    User toEntity(UserValidDTO dto, String encoder);

    @Mapping(source = "user.userId", target = "userId")
    @Mapping(source = "user.loginId", target = "loginId")
    @Mapping(source = "user.password", target = "password")
    @Mapping(source = "dto.name", target = "name")
    @Mapping(source = "dto.birth", target = "birth")
    @Mapping(source = "dto.tel", target = "tel")
    @Mapping(source = "dto.email", target = "email")
    @Mapping(source = "dto.addr", target = "addr")
    @Mapping(source = "dto.addrDetail", target = "addrDetail")
    @Mapping(source = "dto.zip", target = "zip")
    @Mapping(source = "dto.gender", target = "gender")
    @Mapping(source = "user.grade", target = "grade")
    @Mapping(target = "resumes", ignore = true)
    User toEntity(UserValidDTO dto, User user);

}
