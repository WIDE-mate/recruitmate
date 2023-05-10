package com.recruit.usermate.web;

import com.recruit.commonmate.util.GlobalException;
import com.recruit.commonmate.util.Code;
import com.recruit.commonmate.response.ResponseData;
import com.recruit.configmate.auth.Login;
import com.recruit.configmate.auth.dto.SessionUser;
import com.recruit.usermate.service.user.UserService;
import com.recruit.usermate.web.dto.LoginDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.SecureRandom;
import java.util.Base64;

import static com.recruit.commonmate.util.GlobalVariables.*;

@Tag(name = "유저 권한", description = "유저 권한 관련 처리 API 입니다.")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class LoginController {

    private final UserService userService;
    private final HttpSession httpSession;

    @Operation(summary = "사용자 로그인 API",
            description = "로그인 정보(아이디 & 비밀번호)가 올바르면 세션을 생성하고, 생성한 세션의 키를 반환합니다. " +
                    "로그인 정보가 올바르지 않으면 세션을 생성하지 않으며, null을 반환합니다. " +
                    "이미 로그인하였으면 강제 로그아웃 처리한다")
    @PostMapping("/login")
    public ResponseData<String> login(@RequestBody LoginDTO dto){
        LoginDTO user = userService.login(dto);
        if (user == null) return ResponseData.empty();
        String key = madeRandomString();
        httpSession.invalidate();
        httpSession.setAttribute(LOGINKEY, key);
        httpSession.setAttribute(USER, new SessionUser(user));
        return ResponseData.of(key);
    }

    @Operation(summary = "사용자 로그아웃 API",
            description = "로그인 세션 키가 일치하면 현재 세션을 무효화하고 1을 반환")
    @GetMapping("/logout/{loginKey}")
    public ResponseData<String> logout(@PathVariable String loginKey){
        if (httpSession == null || !loginKey.equals(httpSession.getAttribute(LOGINKEY)))
            throw new GlobalException(Code.NOT_SESSION);
        httpSession.invalidate();
        return ResponseData.of("1");
    }

    @Operation(summary = "세션 정보 반환 API",
            description = "로그인 세션이 존재하고, 로그인한 사용자 정보를 찾으면 해당 사용자의 세션 정보를 반환합니다.")
    @GetMapping("/{loginKey}")
    public ResponseData<SessionUser> getSession(@Parameter(hidden = true) @Login SessionUser user,
            @Parameter(name = "loginKey", description = "로그인 키") @PathVariable String loginKey){
        if (httpSession == null || !loginKey.equals(httpSession.getAttribute(LOGINKEY)))
            throw new GlobalException(Code.NOT_SESSION);
        if (user == null)
            throw new GlobalException(Code.NOT_IN_USER);
        return ResponseData.of(user);
    }

    @Operation(summary = "아이디 중복 체크 API",
            description = "중복되는 아이디가 없으면 1을 반환하고, 중복되는 아이디가 있으면 0을 반환합니다.")
    @GetMapping("/dup-chk/{id}")
    public ResponseData<String> dupliId(@PathVariable String id){
        return ResponseData.of(!userService.dupliId(id) ? "1" : "0");
    }

    private String madeRandomString(){
        byte [] bytes = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }

}
