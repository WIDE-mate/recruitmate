package com.recruit.recruitmate.web;

import com.recruit.commonmate.dto.ResponseData;
import com.recruit.recruitmate.service.recruit.RecruitService;
import com.recruit.recruitmate.web.dto.RecruitDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/re")
public class RecruitController {

    private final RecruitService recruitService;

    @PostMapping("/save")
    public ResponseData<Object> recruitSave(RecruitDTO dto){
        // 예외처리
        recruitService.recruitSave(dto);
        return ResponseData.of(null);
    }

    @GetMapping("/{recruitId}")
    public ResponseData<Object> getRecruit(@PathVariable String recruitId){
        // 예외처리
        return ResponseData.of(recruitService.getRecruit(recruitId));
    }

}
