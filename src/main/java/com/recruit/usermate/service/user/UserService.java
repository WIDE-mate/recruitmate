package com.recruit.usermate.service.user;

import com.recruit.commonmate.global.GlobalException;
import com.recruit.commonmate.enums.CODE;
import com.recruit.usermate.domain.user.User;
import com.recruit.usermate.domain.user.UserRepository;
import com.recruit.usermate.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final BCryptPasswordEncoder encoder;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    public LoginDTO login(LoginDTO dto){
        User user = userRepository.findByLoginId(dto.getLoginId());
        return user != null && encoder.matches(dto.getPassword(),user.getPassword()) ?
                userMapper.toLoginDTO(user) : null;
    }

    @Transactional
    public String userSave(UserValidDTO dto){
        if (userRepository.existsByLoginId(dto.getLoginId()))
            throw new GlobalException(CODE.DUPLICATE_ID);
        return userRepository.save(userMapper.toEntity(dto, encoder.encode(dto.getPassword())))
                .getUserId().toString();
    }

    @Transactional
    public String userUpdate(UserValidDTO dto){
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new GlobalException(CODE.USER_NOT_FOUND));
        return userRepository.save(userMapper.toEntity(dto,user))
                .getUserId().toString();
    }

    @Transactional
    public void userDelete(Long id){
        if (!userRepository.existsById(id))
            throw new GlobalException(CODE.USER_NOT_FOUND);
        userRepository.deleteById(id);
    }

    @Transactional
    public UserDTO getUser(Long id){
        return userRepository.findById(id)
                .map(userMapper::toUserDTO)
                .orElse(null);
    }

    @Transactional
    public List<UserDTO> getAllUser(){
        return userRepository.findAllBy();
    }

    @Transactional
    public boolean dupliId(String loginId){
        return userRepository.existsByLoginId(loginId);
    }

}
