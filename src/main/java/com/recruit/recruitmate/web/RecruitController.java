package com.recruit.recruitmate.web;

import com.recruit.recruitmate.service.recruit.RecruitService;
import com.recruit.recruitmate.web.dto.RecruitDTO;
import com.recruit.systemmate.util.ResponseUtil;
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
    public ResponseEntity<Map<String ,Object>> recruitSave(RecruitDTO dto){
        // 예외처리
        recruitService.recruitSave(dto);
        return ResponseUtil.ok(null);
    }

    @GetMapping("/{recruitId}")
    public ResponseEntity<Map<String ,Object>> getRecruit(@PathVariable String recruitId){
        // 예외처리
        return ResponseUtil.ok(recruitService.getRecruit(recruitId));
    }

}
