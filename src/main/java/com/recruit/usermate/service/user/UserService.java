package com.recruit.usermate.service.user;

import com.recruit.systemmate.util.BcryptEncoder;
import com.recruit.usermate.domain.user.UserRepository;
import com.recruit.usermate.web.dto.LoginDTO;
import com.recruit.usermate.web.dto.UserDTO;
import com.recruit.usermate.web.dto.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    public LoginDTO login(LoginDTO dto){
        return userMapper.toLoginDTO(userRepository.findByloginIdAndPassword(dto.getLoginId(), dto.getPassword()));
    }

    @Transactional
    public boolean dupliId(String loginId){
        return userRepository.existsByloginId(loginId);
    }

    @Transactional
    public void save(UserDTO dto){
        userRepository.save(userMapper.toUserDTO(dto));
    }
    
}
