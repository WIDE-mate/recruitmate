package com.recruit.resumemate.web;

import com.recruit.commonmate.response.ResponseData;
import com.recruit.resumemate.service.resume.ResumeService;
import com.recruit.resumemate.web.dto.ResumeDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/resume")
public class ResumeController {

    // 전체적으로 이미지 처리 어떻게 할지 고민하기

    private final ResumeService resumeService;
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
    public ResponseData<ResumeDTO> getResume(@Parameter(name = "resumeId", description = "이력서 번호", required = true)
                                        @PathVariable Long resumeId){
        return ResponseData.of(resumeService.getResume(resumeId));
    }

    //본인 이력서 => 보안이 필요하니 User에서?

    //이력서 전부
    @Operation(summary = "이력서 전체 조회 API", description = "이력서 전체 정보 조회 - 대외활동 등 상세 정보는 가져오지 않는다.")
    @GetMapping("/all")
    public ResponseData<List<ResumeDTO>> getAllResume(){
        return ResponseData.of(resumeService.getAllResuem());
    }

}
