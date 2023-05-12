package com.recruit.recruitmate.web;

import com.recruit.commonmate.response.ResponseData;
import com.recruit.recruitmate.service.recruit.RecruitService;
import com.recruit.recruitmate.web.dto.RecruitDTO;
import com.recruit.recruitmate.web.dto.RecruitValidDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Tag(name = "채용 APi", description = "채용 정보 API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/recruit")
public class RecruitController {

    private final RecruitService recruitService;

    @Operation(summary = "채용 정보 저장 API",description = "성공 시에 채용 ID 반환")
    @PostMapping("/save")
    public ResponseData<String> recruitSave(@RequestBody @Valid RecruitValidDTO dto){
        return ResponseData.of(recruitService.recruitSave(dto).getRecruitId().toString());
    }

    @Operation(summary = "채용 정보 수정 API",description = "성공 시에 채용 ID 반환")
    @PutMapping("/update")
    public ResponseData<String> recruitUpdate(@RequestBody @Valid RecruitValidDTO dto){
        return ResponseData.of(recruitService.recruitUpdate(dto).getRecruitId().toString());
    }

    @Operation(summary = "채용 정보 삭제 API",description = "성공시에 1을 반환")
    @DeleteMapping("/delete/{recruitId}")
    public ResponseData<String> recruitDelete(@Parameter(name = "recruitId", description = "채용번호",required = true)
            @PathVariable String recruitId){
        recruitService.recruitDelete(Long.valueOf(recruitId));
        return ResponseData.of("1");
    }

    @Operation(summary = "채용 정보 조회 API",description = "특정 채용 정보 반환")
    @GetMapping("/{recruitId}")
    public ResponseData<RecruitDTO> getRecruit(@Parameter(name = "recruitId", description = "채용번호",required = true)
            @PathVariable String recruitId){
        return ResponseData.of(recruitService.getRecruit(Long.valueOf(recruitId)));
    }

    @Operation(summary = "채용 정보 전체 조회 API",description = "전체 채용 정보 반환")
    @GetMapping("/all")
    public ResponseData<List<RecruitDTO>> getAllRecruit(){
        return ResponseData.of(recruitService.getAllRecruit());
    }

    @Operation(summary = "신입/경력 갯수 조회 API",description = "신입/경력 갯수 반환")
    @GetMapping("/cnt-career")
    public ResponseData<Map<String,Long>> countCareer(@Parameter(name = "period", description = "채용 만료 기간")
            @RequestParam(name = "period", defaultValue = "${now}") LocalDate period){
        return ResponseData.of(recruitService.cntCareer(period));
    }
    

}
