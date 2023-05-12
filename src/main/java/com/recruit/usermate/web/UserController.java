package com.recruit.usermate.web;

import com.recruit.commonmate.global.GlobalException;
import com.recruit.commonmate.enums.CODE;
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

import static com.recruit.commonmate.global.GlobalVariables.LOGINKEY;

@Tag(name = "유저 정보", description = "유저 정보 관련 API 입니다.")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final HttpSession httpSession;
    private final UserService userService;

    @Operation(summary = "회원 가입 API",
            description = "성공시에 loginId를 반환")
    @PostMapping("/save")
    public ResponseData<String> userSave (@RequestBody @Valid SignupDTO dto){
        return ResponseData.of(userService.userSave(dto).getLoginId());
    }

    @Operation(summary = "회원 정보 수정 API",
            description = "성공시에 loginId를 반환<br>(로그인키값 보내주셔야 합니다.)"
    )
    @PutMapping("/update")
    public ResponseData<String> userUpdate(@Parameter(hidden = true) @Login SessionUser user,
            @io.swagger.v3.oas.annotations.parameters.RequestBody @RequestBody @Valid SignupDTO dto){
        httpSessionException(dto.getLoginKey(), user);
        return ResponseData.of(userService.userUpdate(dto.withUserId(user.getUserId())).getLoginId());
    }

    @Operation(summary = "회원 탈퇴 API",
            description = "성공시에 1을 반환")
    @DeleteMapping("/delete/{loginKey}")
    public ResponseData<String> userDelete(@Parameter(hidden = true) @Login SessionUser user,
            @Parameter(name = "loginKey", description = "로그인 키", required = true) @PathVariable String loginKey){
        httpSessionException(loginKey, user);
        userService.userDelete(user.getUserId());
        return ResponseData.of("1");
    }

    @Operation(summary = "특정 사용자 정보 조회 API",
            description = "특정 사용자 정보 반환")
    @GetMapping("/{userId}")
    public ResponseData<UserDTO> getUser(
            @Parameter(name = "userId", description = "유저 번호", required = true) @PathVariable Long userId){
        return ResponseData.of(userService.getUser(userId));
    }

    @Operation(summary = "로그인 사용자 정보 조회 API",
            description = "현재 로그인한 사용자 정보 반환")
    @GetMapping("/get-me/{loginKey}")
    public ResponseData<UserDTO> getMe(@Parameter(hidden = true) @Login SessionUser user,
            @Parameter(name = "loginKey", description = "로그인 키", required = true) @PathVariable String loginKey){
        httpSessionException(loginKey, user);
        return ResponseData.of(userService.getUser(user.getUserId()));
    }

    @Operation(summary = "모든 사용자 정보 조회 API",
            description = "모든 사용자 정보 반환")
    @GetMapping("/all")
    public ResponseData<List<UserDTO>> getAllUser(){
        return ResponseData.of(userService.getAllUser());
    }

    private void httpSessionException(String loginKey, SessionUser user){
        if (httpSession == null || !loginKey.equals(httpSession.getAttribute(LOGINKEY)))
            throw new GlobalException(CODE.NOT_SESSION);
        if (user == null)
            throw new GlobalException(CODE.NOT_IN_USER);
    }

}
