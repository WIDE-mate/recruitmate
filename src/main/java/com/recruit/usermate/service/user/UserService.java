package com.recruit.usermate.service.user;

import com.recruit.usermate.domain.user.User;
import com.recruit.usermate.domain.user.UserRepository;
import com.recruit.usermate.web.dto.LoginDTO;
import com.recruit.usermate.web.dto.UserDTO;
import com.recruit.usermate.web.dto.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder encoder;

    @Transactional
    public LoginDTO login(LoginDTO dto){
        List<User> users = userRepository.findByloginId(dto.getLoginId());
        if (users.size() == 1 && encoder.matches(dto.getPassword(),users.get(0).getPassword()))
            return userMapper.toLoginDTO(users.get(0));
        else if(users.size() > 1)
            return null;  // 행이 2개 나오는 에러처리 필요
        else
            return null;
    }

    @Transactional
    public UserDTO save(UserDTO dto){
        return userMapper.toUserDTO(userRepository.save(
                User.builder().loginId(dto.getLoginId()).password(encoder.encode(dto.getPassword())).name(dto.getName())
                .birth(dto.getBirth()).tel(dto.getTel()).email(dto.getEmail()).addr(dto.getAddr())
                .addrDetail(dto.getAddrDetail()).zip(dto.getZip()).grade(dto.getGrade()).gender(dto.getGender()).build()));
    }

    @Transactional
    public void delete(Long id){
        userRepository.deleteById(id);
    }

    @Transactional
    public UserDTO update(UserDTO dto){
        // null 반환 혹은 null save 처리
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toUserDTO(userRepository.save(User.builder().userId(user.getUserId()).loginId(user.getLoginId()).password(user.getPassword())
                .name(dto.getName()).birth(dto.getBirth()).tel(dto.getTel()).email(dto.getEmail())
                .addr(dto.getAddr()).addrDetail(dto.getAddrDetail()).zip(dto.getZip()).gender(dto.getGender())
                .grade(user.getGrade()).build()));
    }

    @Transactional
    public UserDTO findById(Long id){
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent())
            return userMapper.toUserDTO(user.get());
        else
            return null;
    }

    @Transactional
    public List<UserDTO> findAll(){
        return userRepository.findAll().stream()
                .map(user -> userMapper.toUserDTO(user))
                .collect(Collectors.toList());
    }

    @Transactional
    public boolean dupliId(String loginId){
        return userRepository.existsByloginId(loginId);
    }

}
