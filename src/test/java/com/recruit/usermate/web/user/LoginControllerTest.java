package com.recruit.usermate.web.user;

import com.recruit.configmate.auth.dto.SessionUser;
import com.recruit.usermate.domain.user.UserRepository;
import com.recruit.usermate.service.user.UserService;
import com.recruit.usermate.web.dto.LoginDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpSession;
import java.util.Map;

import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoginControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    BCryptPasswordEncoder encoder;

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
        when(httpSession.getAttribute(eq("loginKey"))).thenReturn("dummyLoginKey");
    }

//    @AfterEach
//    private void tearDown() throws Exception{
//        userRepository.deleteAll();
//    }

    @Test
    public void 로그인() throws Exception{
        //given
//        String id = "id";
//        String password = "password";
//        String url = "http://localhost:" + port + "/api/auth/login";
//
//        LoginDTO in = LoginDTO.builder().loginId(id).password("password").grade(Grade.MEMBER).build();
//        UserDTO user = UserDTO.builder().loginId(id).password(password).grade(Grade.MEMBER).gender(Gender.F)
//                .name("name").tel("tel").birth(new Date(2023,12,31)).build();
//
//        userService.save(user).getPassword();
//
//        HttpEntity<LoginDTO> requestEntity = new HttpEntity<>(in);
//
//        //when
//        ResponseEntity<Map> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Map.class);
//
//        //then
//        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//        Assertions.assertThat(responseEntity.getBody().get("result")).isNotNull();


    }

    @Test
    public void 세션정보(){
        // Test 중에는 세션정보가 안 담기므로 가짜로 해야함

        // Given
//        String url = "http://localhost:"+ port + "/api/auth/get-session?loginKey=dummyLoginKey";
//        SessionUser expectedUser = new SessionUser(new LoginDTO(0l,"username", "password",null));
//        when(httpSession.getAttribute(eq("user"))).thenReturn(expectedUser);
//
////        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
////        requestBody.add("loginKey", "dummyLoginKey");
////
////        HttpHeaders headers = new HttpHeaders();
////        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
////
////        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);
//
//        //when
//        ResponseEntity<Map> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, Map.class);
//
//        //then
//        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//        Assertions.assertThat(responseEntity.getBody().get("result")).isNotNull();

    }

}
