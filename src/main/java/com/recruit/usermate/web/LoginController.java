package com.recruit.usermate.web;

import com.recruit.systemmate.config.auth.Login;
import com.recruit.systemmate.config.auth.dto.SessionUser;
import com.recruit.systemmate.handler.exception.HttpSessionRequiredException;
import com.recruit.systemmate.handler.exception.HttpSessionUserNotFoundException;
import com.recruit.systemmate.util.ResponseUtil;
import com.recruit.usermate.service.user.UserService;
import com.recruit.usermate.web.dto.LoginDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Map;

import static com.recruit.systemmate.util.GlobalVariables.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class LoginController {

    private final UserService userService;
    private final HttpSession httpSession;

    /**
     * 로그인 처리
     * @param dto 로그인 정보를 담은 {@link LoginDTO} 객체
     * @return 로그인 결과를 담은 {@link ResponseEntity} 객체. 인증에 성공하면 로그인 세션 키를 포함하고, 실패하면 null을 포함합니다.
     * @apiNote 로그인 정보가 올바르면 세션을 생성하고, 생성한 세션의 키를 반환합니다. 로그인 정보가 올바르지 않으면 세션을 생성하지 않으며, null을 반환합니다. 
     *          이미 로그인하였으면 강제 로그아웃 처리한다
     */
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginDTO dto){
        LoginDTO user = userService.login(dto);
        if (user == null) return ResponseUtil.ok(null);
        String key = madeRandomString();
        httpSession.invalidate();
        httpSession.setAttribute(LOGINKEY, key);
        httpSession.setAttribute(USER, new SessionUser(user));
        return ResponseUtil.ok(key);
    }

    /**
     * 로그아웃 처리
     * @param loginKey 로그인 세션 키
     * @return 로그아웃 결과를 담은 {@link ResponseEntity} 객체. 로그인 세션 키가 일치하면 true를 반환하고, 그렇지 않으면 false를 반환합니다.
     * @apiNote 로그인 세션 키가 일치하면 현재 세션을 무효화하고 true를 반환
     */
    @GetMapping("/logout/{loginKey}")
    @ExceptionHandler(value = {HttpSessionRequiredException.class})
    public ResponseEntity<Map<String, Object>> logout(@PathVariable String loginKey){
        if (httpSession == null || !loginKey.equals(httpSession.getAttribute(LOGINKEY)))
            throw new HttpSessionRequiredException();
        httpSession.invalidate();
        return ResponseUtil.trueToOne(true);
    }

    /**
     * 세션 정보 반환
     * @param loginKey 로그인 세션 키
     * @param user 세션에서 찾을 사용자 객체. 이 값을 주입받지 못하면 {@link HttpSessionUserNotFoundException} 예외를 던집니다.
     * @return 로그인한 사용자의 세션 정보를 담은 {@link ResponseEntity} 객체
     * @throws HttpSessionRequiredException 로그인 세션이 없는 경우
     * @throws HttpSessionUserNotFoundException 사용자 정보를 찾을 수 없는 경우
     * @apiNote 로그인 세션이 존재하고, 로그인한 사용자 정보를 찾으면 해당 사용자의 세션 정보를 반환합니다.
     */
    @GetMapping("/{loginKey}")
    @ExceptionHandler(value = {HttpSessionRequiredException.class, HttpSessionUserNotFoundException.class})
    public ResponseEntity<Map<String,Object>> getSession(@PathVariable String loginKey, @Login SessionUser user){
        if (httpSession == null || !loginKey.equals(httpSession.getAttribute(LOGINKEY)))
            throw new HttpSessionRequiredException();
        if (user == null)
            throw new HttpSessionUserNotFoundException();
        return ResponseUtil.ok(user);
    }

    /**
     * 아이디 중복 확인 처리
     * @param id 중복 확인 대상인 아이디
     * @return 중복 여부를 담은 {@link ResponseEntity} 객체
     * @apiNote 중복되는 아이디가 없으면 true를 반환하고, 중복되는 아이디가 있으면 false를 반환합니다.
     */
    @GetMapping("/dup-chk/{id}")
    public ResponseEntity<Map<String,Object>> dupliId(@PathVariable String id){
        return ResponseUtil.trueToOne(!userService.dupliId(id));
    }

    private String madeRandomString(){
        byte [] bytes = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }

}
