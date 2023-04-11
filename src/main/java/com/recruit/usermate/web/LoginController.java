package com.recruit.usermate.web;

import com.recruit.systemmate.config.auth.dto.SessionUser;
import com.recruit.usermate.service.user.UserService;
import com.recruit.usermate.web.dto.LoginDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class LoginController {

    private final UserService memberService;
    private final HttpSession httpSession;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginDTO dto){
        // 세션 처리 필요
        boolean flag = memberService.login(dto);
        if(flag) {
            httpSession.setAttribute("user", new SessionUser(dto.getId()));
        }
        return ResponseEntity.ok(Collections.singletonMap("result", flag));
    }

}
