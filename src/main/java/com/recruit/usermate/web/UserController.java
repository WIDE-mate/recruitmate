package com.recruit.usermate.web;

import com.recruit.systemmate.config.auth.Login;
import com.recruit.systemmate.config.auth.dto.SessionUser;
import com.recruit.systemmate.util.ResponseUtil;
import com.recruit.usermate.service.user.UserService;
import com.recruit.usermate.web.dto.UserDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Optional;

import static com.recruit.systemmate.util.GlobalVariables.LOGINKEY;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final HttpSession httpSession;
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Map<String,Object>> signup (@RequestBody UserDTO dto){
        return ResponseUtil.ok(userService.save(dto).getLoginId());
    }

    // sessionkey가 있는디
    // user정보는 null이 아닌지 공통처리 필요
    
    @DeleteMapping("/withdraw/{loginKey}")
    public ResponseEntity<Map<String,Object>> withdraw(@PathVariable String loginKey, @Login SessionUser user){
        if(httpSession == null || !loginKey.equals(httpSession.getAttribute(LOGINKEY))) return ResponseUtil.ok("No"); // 공통 처리 필요
        userService.delete(user.getUserId());
        return ResponseUtil.ok("Yse");
    }

    @PutMapping("/user-modify")
    public ResponseEntity<Map<String,Object>> userModify(@RequestBody UserDTO dto, @RequestParam String loginKey, @Login SessionUser user){
        if(httpSession == null || !loginKey.equals(httpSession.getAttribute(LOGINKEY))) return ResponseUtil.ok("No"); // 공통 처리 필요
        return ResponseUtil.ok(userService.update(buildWithUserId(user.getUserId(), dto)));
    }

    @GetMapping("/{loginKey}")
    public ResponseEntity<Map<String,Object>> findByMe(@PathVariable String loginKey, @Login SessionUser user){
        if(httpSession == null || !loginKey.equals(httpSession.getAttribute(LOGINKEY))) return ResponseUtil.ok("No"); // 공통 처리 필요
        return  ResponseUtil.ok(userService.findById(user.getUserId()));
    }

    @GetMapping("/one/{id}")
    public ResponseEntity<Map<String,Object>> findByOne(@PathVariable Long id){
        return  ResponseUtil.ok(userService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<Map<String,Object>> findAll(){
        return  ResponseUtil.ok(userService.findAll());
    }

    private UserDTO buildWithUserId(Long id, UserDTO user){
        return UserDTO.builder()
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
