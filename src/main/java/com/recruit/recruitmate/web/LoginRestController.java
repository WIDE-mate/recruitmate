package com.recruit.recruitmate.web;

import com.recruit.recruitmate.config.auth.dto.SessionMember;
import com.recruit.recruitmate.domain.member.Member;
import com.recruit.recruitmate.service.member.MemberService;
import com.recruit.recruitmate.web.dto.LoginDTO;
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
public class LoginRestController {

    private final MemberService memberService;
    private final HttpSession httpSession;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginDTO dto){
        // 세션 처리 필요
        boolean flag = memberService.login(dto);
        if(flag) {
            httpSession.setAttribute("member", new SessionMember(dto.getId()));
        }
        return ResponseEntity.ok(Collections.singletonMap("result", flag));
    }

}
