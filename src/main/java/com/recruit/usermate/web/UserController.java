package com.recruit.usermate.web;

import com.recruit.commonmate.GeneralException;
import com.recruit.commonmate.enums.Code;
import com.recruit.commonmate.dto.ResponseData;
import com.recruit.configmate.auth.Login;
import com.recruit.configmate.auth.dto.SessionUser;
import com.recruit.usermate.service.user.UserService;
import com.recruit.usermate.web.dto.SignupDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static com.recruit.commonmate.GlobalVariables.LOGINKEY;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final HttpSession httpSession;
    private final UserService userService;

    /**
     * 회원 가입
     * @param dto SignupDTO - 가입 정보를 담은 객체
     * @return DataResponse<Object> - 처리 결과를 담은 ResponseEntity 객체
     * @apiNote 성공시에 loginId를 반환한다.
     */
    @PostMapping("/signup")
    public ResponseData<Object> signup (@RequestBody @Valid SignupDTO dto){
        return ResponseData.of(userService.save(dto).getLoginId());
    }

    /**
     * 회원 탈퇴
     * @param loginKey String - 로그인 키 값
     * @param user SessionUser - 현재 로그인한 사용자 정보를 담은 객체
     * @return DataResponse<Object> - 처리 결과를 담은 ResponseEntity 객체
     * @throws GeneralException 로그인 세션이 필요한 경우 발생하는 예외, 로그인한 사용자 정보가 없는 경우 발생하는 예외
     * @apiNote 성공시에 1을 반환한다.
     */
    @DeleteMapping("/withdraw/{loginKey}")
    public ResponseData<Object> withdraw(@PathVariable String loginKey, @Login SessionUser user){
        httpSessionException(loginKey, user);
        userService.delete(user.getUserId());
        return ResponseData.of("1");
    }

    /**
     * 회원 정보 수정
     * @param dto SignupDTO - 수정할 정보를 담은 객체 (loginKey를 가지고있다)
     * @param user SessionUser - 현재 로그인한 사용자 정보를 담은 객체
     * @return DataResponse<Object> - 처리 결과를 담은 ResponseEntity 객체
     * @throws GeneralException 로그인 세션이 필요한 경우 발생하는 예외, 로그인한 사용자 정보가 없는 경우 발생하는 예외
     * @apiNote 성공시에 수정된 유저정보를 반환한다.
     */
    @PutMapping("/user-modify")
    public ResponseData<Object> userModify(@RequestBody @Valid SignupDTO dto, @Login SessionUser user){
        httpSessionException(dto.getLoginKey(), user);
        return ResponseData.of(userService.update(buildWithUserId(user.getUserId(), dto)));
    }
    
    /**
     * 현재 로그인 사용자 정보 조회
     * @param loginKey String - 로그인 키 값
     * @param user SessionUser - 현재 로그인한 사용자 정보를 담은 객체
     * @return DataResponse<Object> - 처리 결과를 담은 ResponseEntity 객체
     * @throws GeneralException 로그인 세션이 필요한 경우 발생하는 예외, 로그인한 사용자 정보가 없는 경우 발생하는 예외
     */
    @GetMapping("/{loginKey}")
    public ResponseData<Object> findByMe(@PathVariable String loginKey, @Login SessionUser user){
        httpSessionException(loginKey, user);
        return ResponseData.of(userService.findById(user.getUserId()));
    }

    /**
     * 특정 사용자 정보 조회
     * @param id Long - 조회할 사용자의 ID
     * @return DataResponse<Object> - 처리 결과를 담은 ResponseEntity 객체
     */
    @GetMapping("/one/{id}")
    public ResponseData<Object> findByOne(@PathVariable Long id){
        return ResponseData.of(userService.findById(id));
    }

    /**
     * 모든 사용자 정보 조회
     * @return DataResponse<Object> - 처리 결과를 담은 ResponseEntity 객체
     */
    @GetMapping("/all")
    public ResponseData<Object> findAll(){
        return ResponseData.of(userService.findAll());
    }

    private void httpSessionException(String loginKey, SessionUser user){
        if (httpSession == null || !loginKey.equals(httpSession.getAttribute(LOGINKEY)))
            throw new GeneralException(Code.NOT_SESSION);
        if (user == null)
            throw new GeneralException(Code.NOT_IN_USER);
    }

    private SignupDTO buildWithUserId(Long id, SignupDTO user){
        return SignupDTO.builder()
                .userId(id)
                .loginId(user.getLoginId())
                .password(user.getPassword())
                .name(user.getName())
                .birth(user.getBirth())
                .tel(user.getTel())
                .email(user.getEmail())
                .addr(user.getAddr())
                .addrDetail(user.getAddrDetail())
                .zip(user.getZip())
                .gender(user.getGender())
                .grade(user.getGrade())
                .build();
    }

}
