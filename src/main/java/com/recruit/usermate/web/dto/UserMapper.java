package com.recruit.usermate.web.dto;

import com.recruit.usermate.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

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

}
