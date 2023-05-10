package com.recruit.usermate.web;

import com.recruit.commonmate.util.GlobalException;
import com.recruit.commonmate.util.Code;
import com.recruit.commonmate.response.ResponseData;
import com.recruit.configmate.auth.Login;
import com.recruit.configmate.auth.dto.SessionUser;
import com.recruit.usermate.service.user.UserService;
import com.recruit.usermate.web.dto.SignupDTO;
import com.recruit.usermate.web.dto.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.List;

import static com.recruit.commonmate.util.GlobalVariables.LOGINKEY;

@Tag(name = "유저 정보", description = "유저 정보 관련 API 입니다.")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final HttpSession httpSession;
    private final UserService userService;

    @Operation(summary = "회원 가입 API",
            description = "성공시에 loginId를 반환")
    @PostMapping("/signup")
    public ResponseData<String> signup (@RequestBody @Valid SignupDTO dto){
        return ResponseData.of(userService.save(dto).getLoginId());
    }

    @Operation(summary = "회원 탈퇴 API",
            description = "성공시에 1을 반환")
    @DeleteMapping("/withdraw/{loginKey}")
    public ResponseData<String> withdraw(@Parameter(hidden = true) @Login SessionUser user,
            @Parameter(name = "loginKey", description = "로그인 키") @PathVariable String loginKey){
        httpSessionException(loginKey, user);
        userService.delete(user.getUserId());
        return ResponseData.of("1");
    }

    @Operation(summary = "회원 정보 수정 API",
            description = "성공시에 loginId를 반환<br>(로그인키값 보내주셔야 합니다.)"
    )
    @PutMapping("/user-modify")
    public ResponseData<String> userModify(@Parameter(hidden = true) @Login SessionUser user,
            @io.swagger.v3.oas.annotations.parameters.RequestBody @RequestBody @Valid SignupDTO dto){
        httpSessionException(dto.getLoginKey(), user);
        return ResponseData.of(userService.update(dto.withUserId(user.getUserId())).getLoginId());
    }

    @Operation(summary = "로그인 사용자 정보 조회 API",
            description = "현재 로그인한 사용자 정보 반환")
    @GetMapping("/{loginKey}")
    public ResponseData<UserDTO> findByMe(@Parameter(hidden = true) @Login SessionUser user,
            @Parameter(name = "loginKey", description = "로그인 키") @PathVariable String loginKey){
        httpSessionException(loginKey, user);
        return ResponseData.of(userService.findById(user.getUserId()));
    }

    @Operation(summary = "특정 사용자 정보 조회 API",
            description = "특정 사용자 정보 반환")
    @GetMapping("/one/{id}")
    public ResponseData<UserDTO> findByOne(
            @Parameter(name = "id", description = "유저 번호") @PathVariable Long id){
        return ResponseData.of(userService.findById(id));
    }

    @Operation(summary = "모든 사용자 정보 조회 API",
            description = "모든 사용자 정보 반환")
    @GetMapping("/all")
    public ResponseData<List<UserDTO>> findAll(){
        return ResponseData.of(userService.findAll());
    }

    private void httpSessionException(String loginKey, SessionUser user){
        if (httpSession == null || !loginKey.equals(httpSession.getAttribute(LOGINKEY)))
            throw new GlobalException(Code.NOT_SESSION);
        if (user == null)
            throw new GlobalException(Code.NOT_IN_USER);
    }

}
