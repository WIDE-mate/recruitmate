package com.recruit.usermate.web.dto;

import com.recruit.usermate.domain.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    LoginDTO toLoginDTO(User user);
    UserDTO toUserDTO(User user);

}
