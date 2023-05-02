package com.recruit.systemmate.util.response;

import com.recruit.usermate.web.dto.UserDTO;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserResponse extends Response<UserDTO> {

    @Builder
    public UserResponse(String status, String reason, UserDTO data) {
        super(status, reason, data);
    }

}
