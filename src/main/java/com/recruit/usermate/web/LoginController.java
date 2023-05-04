package com.recruit.usermate.web;

import com.recruit.commonmate.GlobalException;
import com.recruit.commonmate.enums.Code;
import com.recruit.commonmate.dto.ResponseData;
import com.recruit.configmate.auth.Login;
import com.recruit.configmate.auth.dto.SessionUser;
import com.recruit.usermate.service.user.UserService;
import com.recruit.usermate.web.dto.LoginDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.SecureRandom;
import java.util.Base64;

import static com.recruit.commonmate.GlobalVariables.*;

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
    public ResponseData<Object> login(@RequestBody LoginDTO dto){
        LoginDTO user = userService.login(dto);
        if (user == null) return ResponseData.empty();
        String key = madeRandomString();
        httpSession.invalidate();
        httpSession.setAttribute(LOGINKEY, key);
        httpSession.setAttribute(USER, new SessionUser(user));
        return ResponseData.of(key);
    }

    /**
     * 로그아웃 처리
     * @param loginKey 로그인 세션 키
     * @return 로그아웃 결과를 담은 {@link ResponseEntity} 객체. 로그인 세션 키가 일치하면 true를 반환하고, 그렇지 않으면 false를 반환합니다.
     * @apiNote 로그인 세션 키가 일치하면 현재 세션을 무효화하고 true를 반환
     */
    @GetMapping("/logout/{loginKey}")
    public ResponseData<Object> logout(@PathVariable String loginKey){
        if (httpSession == null || !loginKey.equals(httpSession.getAttribute(LOGINKEY)))
            throw new GlobalException(Code.NOT_SESSION);
        httpSession.invalidate();
        return ResponseData.of("1");
    }

    /**
     * 세션 정보 반환
     * @param loginKey 로그인 세션 키
     * @param user 세션에서 찾을 사용자 객체. 이 값을 주입받지 못하면 {@link GlobalException} 예외를 던집니다.
     * @return 로그인한 사용자의 세션 정보를 담은 {@link ResponseEntity} 객체
     * @throws GlobalException 로그인 세션이 없는 경우, 사용자 정보를 찾을 수 없는 경우
     * @apiNote 로그인 세션이 존재하고, 로그인한 사용자 정보를 찾으면 해당 사용자의 세션 정보를 반환합니다.
     */
    @GetMapping("/{loginKey}")
    public ResponseData<Object> getSession(@PathVariable String loginKey, @Login SessionUser user){
        if (httpSession == null || !loginKey.equals(httpSession.getAttribute(LOGINKEY)))
            throw new GlobalException(Code.NOT_SESSION);
        if (user == null)
            throw new GlobalException(Code.NOT_IN_USER);
        return ResponseData.of(user);
    }

    /**
     * 아이디 중복 확인 처리
     * @param id 중복 확인 대상인 아이디
     * @return 중복 여부를 담은 {@link ResponseEntity} 객체
     * @apiNote 중복되는 아이디가 없으면 true를 반환하고, 중복되는 아이디가 있으면 false를 반환합니다.
     */
    @GetMapping("/dup-chk/{id}")
    public ResponseData<Object> dupliId(@PathVariable String id){
        return ResponseData.of(!userService.dupliId(id) ? "1" : "0");
    }

    private String madeRandomString(){
        byte [] bytes = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }

}
