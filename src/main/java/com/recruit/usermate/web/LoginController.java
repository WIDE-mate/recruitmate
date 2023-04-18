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
import java.util.Objects;

@RequiredArgsConstructor
@RestController
public class LoginController {

    private final UserService memberService;
    private final HttpSession httpSession;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginDTO dto){
        LoginDTO result = memberService.login(dto);
        if(Objects.isNull(result)) httpSession.setAttribute("user", new SessionUser(result));
        return ResponseEntity.ok(Collections.singletonMap("result", Objects.isNull(result)));
    }

    // 로그아웃을,, rest로,,?

    // 탈퇴

}
