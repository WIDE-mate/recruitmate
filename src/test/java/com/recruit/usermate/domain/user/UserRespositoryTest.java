package com.recruit.usermate.domain.user;

import com.recruit.usermate.web.dto.LoginDTO;
import com.recruit.usermate.web.dto.UserMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRespositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @AfterEach
    public void cleanUp(){
        userRepository.deleteAll();
    }

    @Test
    public void 로그인(){
        //given
        String id = "idd";
        String password = "padssword";

        userRepository.save(User.builder().loginId(id).password(password).grade("회원").build());

        //when
        LoginDTO dto = userMapper.toLoginDTO(userRepository.findByloginIdAndPassword(id,password));

        //Then
        Assertions.assertThat(dto).withFailMessage("DTO is null!!").isNotNull();
        Assertions.assertThat(dto.getPassword()).withFailMessage("DTO is null!!").isEqualTo(password);
    }

    @Test
    public void 아이디_중복_확인(){
        //given
        String id = "id";
        String password = "password";

        userRepository.save(User.builder().loginId(id).password(password).grade("회원").build());

        //when
        boolean result = userRepository.existsByloginId("ids");

        //Then
        Assertions.assertThat(result).isFalse();

    }
}