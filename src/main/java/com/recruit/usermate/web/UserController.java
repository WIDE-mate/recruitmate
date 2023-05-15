package com.recruit.usermate.web;

import com.recruit.commonmate.response.ResponseData;
import com.recruit.usermate.service.user.UserService;
import com.recruit.usermate.web.dto.UserValidDTO;
import com.recruit.usermate.web.dto.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@Tag(name = "유저 정보", description = "유저 정보 관련 API 입니다.")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Operation(summary = "회원 가입 API", description = "성공시에 userId를 반환")
    @PostMapping("/save")
    public ResponseData<String> userSave (@RequestBody @Valid UserValidDTO dto){
        return ResponseData.of(userService.userSave(dto));
    }

    @Operation(summary = "회원 정보 수정 API", description = "성공시에 userId를 반환")
    @PutMapping("/update")
    public ResponseData<String> userUpdate(
            @io.swagger.v3.oas.annotations.parameters.RequestBody @RequestBody @Valid UserValidDTO dto){
        return ResponseData.of(userService.userUpdate(dto));
    }

    @Operation(summary = "회원 탈퇴 API",
            description = "성공시에 1을 반환")
    @DeleteMapping("/delete/{userId}")
    public ResponseData<String> userDelete(
            @Parameter(name = "userId", description = "유저 번호", required = true) @PathVariable String userId){
        userService.userDelete(Long.valueOf(userId));
        return ResponseData.of("1");
    }

    @Operation(summary = "특정 사용자 정보 조회 API",
            description = "특정 사용자 정보 반환")
    @GetMapping("/{userId}")
    public ResponseData<UserDTO> getUser(
            @Parameter(name = "userId", description = "유저 번호", required = true) @PathVariable Long userId){
        return ResponseData.of(userService.getUser(userId));
    }

    @Operation(summary = "모든 사용자 정보 조회 API",
            description = "모든 사용자 정보 반환")
    @GetMapping("/all")
    public ResponseData<List<UserDTO>> getAllUser(){
        return ResponseData.of(userService.getAllUser());
    }

}
