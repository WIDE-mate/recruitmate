package com.recruit.usermate.service.user;

import com.recruit.commonmate.GeneralException;
import com.recruit.commonmate.enums.Code;
import com.recruit.usermate.domain.user.User;
import com.recruit.usermate.domain.user.UserRepository;
import com.recruit.usermate.web.dto.LoginDTO;
import com.recruit.usermate.web.dto.SignupDTO;
import com.recruit.usermate.web.dto.UserDTO;
import com.recruit.usermate.web.dto.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {

    private final BCryptPasswordEncoder encoder;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    public LoginDTO login(LoginDTO dto){
        User user = userRepository.findByloginId(dto.getLoginId());
        if (user != null && encoder.matches(dto.getPassword(),user.getPassword()))
            return userMapper.toLoginDTO(user);
        else
            return null;
    }

    @Transactional
    public SignupDTO save(SignupDTO dto){
        if (userRepository.existsByloginId(dto.getLoginId()))
            throw new GeneralException(Code.DUPLICATE_ID);
        return userMapper.toSignupDTO(userRepository.save(dto.toEntity(encoder.encode(dto.getPassword()))));
    }

    @Transactional
    public void delete(Long id){
        if (!userRepository.existsById(id))
            throw new GeneralException(Code.USER_NOT_FOUND);
        userRepository.deleteById(id);
    }

    @Transactional
    public SignupDTO update(SignupDTO dto){
        User user = userRepository.findByloginId(dto.getLoginId());
        if (user == null)
            throw new GeneralException(Code.USER_NOT_FOUND);
        return userMapper.toSignupDTO(userRepository.save(
                dto.toEntity(user.getUserId(),user.getLoginId(),user.getPassword(),user.getGrade())));
    }

    @Transactional
    public UserDTO findById(Long id){
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty())
            throw new GeneralException(Code.USER_NOT_FOUND);
        return userMapper.toUserDTO(user.get());
    }

    @Transactional
    public List<UserDTO> findAll(){
        return userRepository.findAll().stream()
                .map(userMapper::toUserDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public boolean dupliId(String loginId){
        return userRepository.existsByloginId(loginId);
    }

}
