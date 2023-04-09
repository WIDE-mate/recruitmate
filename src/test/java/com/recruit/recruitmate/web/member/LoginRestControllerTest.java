package com.recruit.recruitmate.web.member;

import com.recruit.recruitmate.domain.member.Member;
import com.recruit.recruitmate.domain.member.MemberRepository;
import com.recruit.recruitmate.web.dto.LoginDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoginRestControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MemberRepository memberRepository;

    @AfterEach
    private void tearDown() throws Exception{
        memberRepository.deleteAll();
    }

    @Test
    public void 로그인() throws Exception{
        //given
        String id = "id";
        String password = "password";
        String url = "http://localhost:" + port + "/login";

        LoginDTO loginDTO = LoginDTO.builder().id(id).password(password).build();

        //when
        ResponseEntity<Boolean> responseEntity = restTemplate.postForEntity(url, loginDTO, Boolean.class);

        //then
        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
