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

import static com.recruit.systemmate.util.GlobalVariables.LOGINKEY;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class LoginController {

    private final UserService userService;
    private final HttpSession httpSession;

    // 전체적으로 예외처리 필요
    // sessionkey가 있는디
    // user정보는 null이 아닌지 공통처리 필요

    /**
     * 로그인 처리
     *
     * @param dto 로그인 정보를 담은 {@link LoginDTO} 객체
     * @return 로그인 결과를 담은 {@link ResponseEntity} 객체
     * @apiNote 로그인 정보가 맞으면 세션을 생성하고, 생성한 세션의 키를 반환합니다.
     *          로그인 정보가 틀리면 세션을 생성하지 않고, null을 반환합니다.
     */
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginDTO dto){
        LoginDTO user = userService.login(dto);
        if (Objects.isNull(user)) return ResponseUtil.ok(null);
        String key = BCrypt.hashpw(UUID.randomUUID().toString(),BCrypt.gensalt()).replaceAll("[/-]+", "").substring(0, 16);
        httpSession.setAttribute(LOGINKEY, key);
        httpSession.setAttribute("user", new SessionUser(user));
        return ResponseUtil.ok(key);
    }

    /**
     * 로그아웃 처리
     *
     * @param loginKey 현재 로그인된 사용자의 loginKey 값
     * @return 로그아웃 처리 결과를 반환합니다. 로그아웃이 성공적으로 처리되었을 경우 true를 반환하고, 실패한 경우 false를 반환합니다.
     */
    @GetMapping("/logout/{loginKey}")
    public ResponseEntity<Map<String, Object>> logout(@PathVariable String loginKey){
        boolean isLogin = httpSession != null && loginKey.equals(httpSession.getAttribute(LOGINKEY));
        if(isLogin) httpSession.invalidate();
        return ResponseUtil.trueToOne(isLogin);
    }

    /**
     * 사용자 세션 정보 조회
     *
     * @param loginKey 세션 키 값
     * @param user     세션 정보에 저장된 사용자 정보
     * @return 조회된 세션 정보가 있을 경우 사용자 정보, 없을 경우 null
     */
    @GetMapping("/{loginKey}")
    public ResponseEntity<Map<String,Object>> getSession(@PathVariable String loginKey, @Login SessionUser user){
        return ResponseUtil.ok(Optional.ofNullable(httpSession)
                .map(session -> session.getAttribute(LOGINKEY))
                .map(Object::toString)
                .filter(loginKey::equals)
                .map(session -> user)
                .orElse(null));
    }

    /**
     * 중복 아이디 체크
     *
     * @param id - 아이디 값
     * @return 중복되지 않은 경우 true, 중복인 경우 false
     */
    @GetMapping("/dup-chk/{id}")
    public ResponseEntity<Map<String,Object>> dupliId(@PathVariable String id){
        return ResponseUtil.trueToOne(!userService.dupliId(id));
    }

}
