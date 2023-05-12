package com.recruit.resumemate.web;

import com.recruit.commonmate.enums.CODE;
import com.recruit.commonmate.global.GlobalException;
import com.recruit.commonmate.response.ResponseData;
import com.recruit.configmate.auth.Login;
import com.recruit.configmate.auth.dto.SessionUser;
import com.recruit.resumemate.service.resume.ResumeService;
import com.recruit.resumemate.web.dto.ResumeDTO;
import com.recruit.resumemate.web.dto.ResumeJoinDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

import static com.recruit.commonmate.global.GlobalVariables.LOGINKEY;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/resume")
public class ResumeController {

    // 전체적으로 이미지 처리 어떻게 할지 고민하기

    private final ResumeService resumeService;
    private final HttpSession httpSession;
    //저장

    //수정

    //삭제
    @Operation(summary = "이력서 삭제 API", description = "성공시에 1을 반환")
    @GetMapping("/delete/{resumeId}")
    public ResponseData<String> resumeDelete(@Parameter(name = "resumeId", description = "이력서 번호", required = true)
                @PathVariable Long resumeId){
        resumeService.resumeDelete(resumeId);
        return ResponseData.of("1");
    }

    //특정 이력서
    @Operation(summary = "특정 이력서 조회 API", description = "이력서 상세 정보 조회")
    @GetMapping("/{resumeId}")
    public ResponseData<ResumeJoinDTO> getResume(@Parameter(name = "resumeId", description = "이력서 번호", required = true)
                @PathVariable Long resumeId){
        return ResponseData.of(resumeService.getResume(resumeId));
    }

    @Operation(summary = "유저 관련 이력서 조회 API", description = "유저 관련 이력서 전체 정보 조회 - 대외활동 등 상세 정보는 가져오지 않는다.")
    @GetMapping("/get-user/{loginKey}")
    public ResponseData<List<ResumeDTO>> getResumeByUser(@Parameter(hidden = true) @Login SessionUser user,
                @Parameter(name = "loginKey", description = "로그인 키", required = true) @PathVariable String loginKey){
        if (httpSession == null || !loginKey.equals(httpSession.getAttribute(LOGINKEY)))
            throw new GlobalException(CODE.NOT_SESSION);
        if (user == null)
            throw new GlobalException(CODE.NOT_IN_USER);
        return ResponseData.of(resumeService.getResumeByUser(0L));
    }

    @Operation(summary = "채용 관련 이력서 조회 API", description = "채용 관련 이력서 전체 정보 조회 - 대외활동 등 상세 정보는 가져오지 않는다.")
    @GetMapping("/get-recruit/{recruitId}")
    public ResponseData<List<ResumeDTO>> getResumeByRecruit(@Parameter(name = "recruitId", description = "채용 번호", required = true)
            @PathVariable Long recruitId){
        return ResponseData.of(resumeService.getResumeByRecruit(recruitId));
    }

    @Operation(summary = "이력서 전체 조회 API", description = "이력서 전체 정보 조회 - 대외활동 등 상세 정보는 가져오지 않는다.")
    @GetMapping("/all")
    public ResponseData<List<ResumeDTO>> getAllResume(){
        return ResponseData.of(resumeService.getAllResume());
    }

}
