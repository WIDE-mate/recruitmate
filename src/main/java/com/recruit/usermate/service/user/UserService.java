package com.recruit.usermate.service.user;

import com.recruit.usermate.domain.user.User;
import com.recruit.usermate.domain.user.UserRepository;
import com.recruit.usermate.web.dto.LoginDTO;
import com.recruit.usermate.web.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public LoginDTO login(LoginDTO dto){
        return null;
//        return userRepository.login(dto.getId(), dto.getPassword());
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
