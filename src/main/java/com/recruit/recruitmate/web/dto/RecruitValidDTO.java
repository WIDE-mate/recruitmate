package com.recruit.recruitmate.web.dto;

import com.recruit.commonmate.comcode.enums.CAREER;
import com.recruit.commonmate.comcode.enums.REQUIRES;
import com.recruit.commonmate.comcode.enums.TASK;
import com.recruit.recruitmate.domain.recruit.Recruit;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Schema(title = "RecruitValidDTO", description = "채용 유효성 체크 DTO")
@Getter
@NoArgsConstructor
public class RecruitValidDTO {

    @Schema(title = "채용 번호")
    private Long recruitId;

    @Schema(title = "제목")
    @NotEmpty(message = "제목은 필수 입력입니다.")
    @Size(max = 1000,message = "제목 저장길이를 초과합니다.")
    private String reTitle;

    @Schema(title = "내용")
    @NotEmpty(message = "내용은 필수 입력입니다.")
    @Size(max = 4000,message = "제목 저장길이를 초과합니다.")
    private String reContent;

    @Schema(title = "지원기간")
    @NotNull(message = "지원기간은 필수 입력입니다.")
    private LocalDate period;

    @Schema(title = "지원조건")
    @NotNull(message = "지원조건은 필수 입력입니다.")
    private REQUIRES requires;

    @Schema(title = "직무")
    @NotNull(message = "직무는 필수 입력입니다.")
    private TASK task;

    @Schema(title = "채용구분")
    @NotNull(message = "채용구분은 필수 입력입니다.")
    private CAREER career;

    @Builder
    public RecruitValidDTO(Long recruitId, String reTitle, String reContent, LocalDate period,
                           REQUIRES requires, TASK task, CAREER career) {
        this.recruitId = recruitId;
        this.reTitle = reTitle;
        this.reContent = reContent;
        this.period = period;
        this.requires = requires;
        this.task = task;
        this.career = career;
    }

    public Recruit toEntity(){
        return Recruit.builder().recruitId(recruitId).reTitle(reTitle).reContent(reContent)
                .period(period).requires(requires).task(task).career(career).build();
    }

}
