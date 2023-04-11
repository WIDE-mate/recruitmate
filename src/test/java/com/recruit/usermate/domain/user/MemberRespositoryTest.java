package com.recruit.usermate.domain.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberRespositoryTest {

    @Autowired
    UserRepository memberRepository;

    @AfterEach
    public void cleanUp(){
        memberRepository.deleteAll();
    }

    @Test
    public void 로그인(){
        //given
        String id = "id";
        String password = "password";

        memberRepository.save(User.builder().id(id).password(password).build());

        //when
        String result = memberRepository.login(id,password);

        //Then
        Assertions.assertThat(id).isEqualTo(result);
    }
}
