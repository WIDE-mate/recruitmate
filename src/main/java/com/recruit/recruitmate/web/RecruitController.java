package com.recruit.recruitmate.web;

import com.recruit.commonmate.dto.ResponseData;
import com.recruit.recruitmate.service.recruit.RecruitService;
import com.recruit.recruitmate.web.dto.RecruitDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Tag(name = "채용 APi", description = "채용 정보 API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/re")
public class RecruitController {

    private final RecruitService recruitService;

    @Operation(summary = "채용 정보 저장 API",description = "설명")
    @PostMapping("/save")
    public ResponseData<RecruitDTO> recruitSave(@RequestBody @Valid RecruitDTO dto){
        // 예외처리
        recruitService.recruitSave(dto);
        return ResponseData.of(null);
    }

    @Operation(summary = "채용 정보 수정 API",description = "설명")
    @PutMapping("/update")
    public ResponseData<RecruitDTO> recruitUpdate(@RequestBody @Valid RecruitDTO dto){
        // 예외처리
        recruitService.recruitSave(dto);
        return ResponseData.of(null);
    }

    @Operation(summary = "채용 정보 삭제 API",description = "설명")
    @DeleteMapping("/delete")
    public ResponseData<String> recruitDelete(@RequestBody @Valid RecruitDTO dto){
        // 예외처리
        recruitService.recruitSave(dto);
        return ResponseData.of(null);
    }

    @Operation(summary = "채용 정보 조회 API",description = "설명")
    @GetMapping("/{recruitId}")
    public ResponseData<Object> getRecruit(@PathVariable String recruitId){
        // 예외처리
        return ResponseData.of(recruitService.getRecruit(recruitId));
    }

    @Operation(summary = "채용 정보 전체 조회 API",description = "설명")
    @GetMapping("/all")
    public ResponseData<Object> getAllRecruit(@PathVariable String recruitId){
        // 예외처리
        return ResponseData.of(recruitService.getRecruit(recruitId));
    }

}
