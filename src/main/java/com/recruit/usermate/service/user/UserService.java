package com.recruit.usermate.service.user;

import com.recruit.usermate.domain.user.UserRepository;
import com.recruit.usermate.web.dto.LoginDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository memberRepository;

    @Transactional
    public Boolean login(LoginDTO loginDTO){
        return !Objects.isNull(memberRepository.login(loginDTO.getId(), loginDTO.getPassword()));
    }

}
