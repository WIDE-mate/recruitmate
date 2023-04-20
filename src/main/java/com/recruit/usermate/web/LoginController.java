package com.recruit.usermate.web;

import com.recruit.systemmate.config.auth.dto.SessionUser;
import com.recruit.usermate.service.user.UserService;
import com.recruit.usermate.web.dto.LoginDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

@RequiredArgsConstructor
@RestController
public class LoginController {

    private final UserService userService;
    private final HttpSession httpSession;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginDTO dto){
        LoginDTO result = userService.login(dto);
        if(result != null) httpSession.setAttribute("user", new SessionUser(result));
        // 로그인 키 처리, 암호화 처리
        return ResponseEntity.ok(Collections.singletonMap("result", Objects.isNull(result)));
    }

    @GetMapping("/dupliId/{id}")
    public ResponseEntity<Map<String,Object>> dupliId(){
        return ResponseEntity.ok(Collections.singletonMap("result","1"));
    }

}
