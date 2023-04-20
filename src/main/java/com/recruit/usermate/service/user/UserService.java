package com.recruit.usermate.service.user;

import com.recruit.usermate.domain.user.UserRepository;
import com.recruit.usermate.web.dto.LoginDTO;
import com.recruit.usermate.web.dto.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    public LoginDTO login(LoginDTO dto){
        return userMapper.toLoginDTO(userRepository.findByIdAndPassword(dto.getId(), dto.getPassword()));
    }

    @Transactional
    public boolean dupliId(String id){
        return false;
//        return userRepository.findById(id) != null;
    }
    
    // 비회원 로그인
//    @Transactional
//    public void withdraw(LoginDTO dto){
////        userRepository.deleteById(dto.getId());
//    }

    // 회원 가입
//    @Transactional
//    public void join(UserDTO dto){
//    }
    
    // 비회원 가입
    
    // 회원 정보
    
}
