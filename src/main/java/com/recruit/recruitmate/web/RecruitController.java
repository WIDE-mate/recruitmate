package com.recruit.recruitmate.web;

import com.recruit.commonmate.dto.ResponseData;
import com.recruit.recruitmate.service.recruit.RecruitService;
import com.recruit.recruitmate.web.dto.RecruitDTO;
import com.recruit.recruitmate.web.dto.RecruitValidDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Tag(name = "채용 APi", description = "채용 정보 API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/re")
public class RecruitController {

    private final RecruitService recruitService;

    @Operation(summary = "채용 정보 저장 API",description = "pk 자동 생성")
    @PostMapping("/save")
    public ResponseData<String> recruitSave(@RequestBody @Valid RecruitValidDTO dto){
        return ResponseData.of(recruitService.recruitSave(dto).getRecruitId().toString());
    }

    @Operation(summary = "채용 정보 수정 API",description = "설명")
    @PutMapping("/update")
    public ResponseData<String> recruitUpdate(@RequestBody @Valid RecruitValidDTO dto){
        return ResponseData.of(recruitService.recruitUpdate(dto).getRecruitId().toString());
    }

    @Operation(summary = "채용 정보 삭제 API",description = "설명")
    @DeleteMapping("/delete/{recruitId}")
    public ResponseData<String> recruitDelete(@PathVariable String recruitId){
        recruitService.recruitDelete(Long.valueOf(recruitId));
        return ResponseData.of("1");
    }

    @Operation(summary = "채용 정보 조회 API",description = "설명")
    @GetMapping("/{recruitId}")
    public ResponseData<RecruitDTO> getRecruit(@PathVariable String recruitId){
        return ResponseData.of(recruitService.getRecruit(Long.valueOf(recruitId)));
    }

    @Operation(summary = "채용 정보 전체 조회 API",description = "만료된 채용까지 전체 조회")
    @GetMapping("/all")
    public ResponseData<List<RecruitDTO>> getAllRecruit(){
        return ResponseData.of(recruitService.getAllRecruit());
    }

}
