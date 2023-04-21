package com.recruit.usermate.web;

import com.recruit.systemmate.config.auth.Login;
import com.recruit.systemmate.config.auth.dto.SessionUser;
import com.recruit.systemmate.util.ResponseUtil;
import com.recruit.usermate.service.user.UserService;
import com.recruit.usermate.web.dto.LoginDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class LoginController {

    private final UserService userService;
    private final HttpSession httpSession;
    private final String keyName = "loginKey";

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginDTO dto){
        if (Objects.isNull(userService.login(dto))) return ResponseUtil.ok(null);
        String key = BCrypt.hashpw(UUID.randomUUID().toString().replaceAll("[/-]", "").substring(0, 16),BCrypt.gensalt());
        httpSession.setAttribute(keyName, key);
        httpSession.setAttribute("user", new SessionUser(dto));
        return ResponseUtil.ok(key);
    }

    @GetMapping("/logout/{loginKey}")
    public ResponseEntity<Map<String, Object>> logout(@PathVariable String loginKey){
        boolean isLogin = httpSession != null && loginKey.equals(httpSession.getAttribute(keyName));
        if(isLogin) httpSession.invalidate();
        return ResponseUtil.trueToOne(isLogin);
    }

    @GetMapping("/{loginKey}")
    public ResponseEntity<Map<String,Object>> getSession(@PathVariable String loginKey, @Login SessionUser user){
        return ResponseUtil.ok(Optional.ofNullable(httpSession)
                .map(session -> session.getAttribute(keyName))
                .map(Object::toString)
                .filter(loginKey::equals)
                .map(session -> user)
                .orElse(null));
    }

    @PostMapping("/check-duplicate-id")
    public ResponseEntity<Map<String,Object>> dupliId(@RequestBody LoginDTO dto){
        return ResponseUtil.trueToOne(!userService.dupliId(dto.getLoginId()));
    }

}
