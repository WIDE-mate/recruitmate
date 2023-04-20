package com.recruit.usermate.web.user;

import com.recruit.systemmate.config.auth.dto.SessionUser;
import com.recruit.usermate.domain.user.UserRepository;
import com.recruit.usermate.service.user.UserService;
import com.recruit.usermate.web.dto.LoginDTO;
import com.recruit.usermate.web.dto.UserDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoginControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Mock
    private HttpSession httpSession;

    @BeforeEach
    public void setup() {
        SessionUser expectedUser = new SessionUser(new LoginDTO(0l,"username", "password",""));
        when(httpSession.getAttribute(eq("loginKey"))).thenReturn("dummyLoginKey");
        when(httpSession.getAttribute(eq("user"))).thenReturn(expectedUser);
    }

    @AfterEach
    private void tearDown() throws Exception{
        userRepository.deleteAll();
    }

    @Test
    public void 로그인() throws Exception{
        //given
        String id = "id";
        String password = "password";
        String url = "http://localhost:" + port + "/api/auth/login";

        LoginDTO in = LoginDTO.builder().loginId(id).password(password).grade("회원").build();
        userService.save(UserDTO.builder().loginId(id).password(password).grade("회원").build());

        HttpEntity<LoginDTO> requestEntity = new HttpEntity<>(in);

        //when
        ResponseEntity<Map> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Map.class);

        //then
        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(responseEntity.getBody().get("result")).isNotNull();

        //=======
        url = "http://localhost:" + port + "/api/user/check-duplicate-id";
        HttpEntity<LoginDTO> requestEntity2 = new HttpEntity<>(in);

        //when
        ResponseEntity<Map> responseEntity2 = restTemplate.exchange(url, HttpMethod.POST, requestEntity2, Map.class);

        //then
        Assertions.assertThat(responseEntity2.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(responseEntity2.getBody().get("result")).isEqualTo("0");
    }

    @Test
    public void 세션정보(){
        // Test 중에는 세션정보가 안 담기므로 가짜로 해야함

        // Given
        String url = "http://localhost:"+ port + "/api/auth/get-session";

        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("loginKey", "dummyLoginKey");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);

        //when
        ResponseEntity<Map> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Map.class);

        //then
        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(responseEntity.getBody().get("result")).isNotNull();

        verify(httpSession).getAttribute(eq("loginKey"));
        verify(httpSession).getAttribute(eq("user"));

    }

}