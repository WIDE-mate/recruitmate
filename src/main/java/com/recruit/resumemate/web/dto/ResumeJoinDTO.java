package com.recruit.resumemate.web.dto;

import com.recruit.commonmate.comcode.enums.GENDER;
import com.recruit.commonmate.comcode.enums.STATE;
import com.recruit.commonmate.enums.CHECK;
import com.recruit.recruitmate.domain.recruit.Recruit;
import com.recruit.resumemate.domain.activity.Activity;
import com.recruit.resumemate.domain.education.Education;
import com.recruit.resumemate.domain.info.Info;
import com.recruit.resumemate.domain.license.License;
import com.recruit.usermate.domain.user.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Schema(title = "ResumeJoinDTO" , description = "이력서 및 상세정보 DTO")
@Getter
@NoArgsConstructor
public class ResumeJoinDTO {

    @Schema(title = "이력서 번호")
    private Long resumeId;
    @Schema(title = "유저 정보")
    private Long userId;
    @Schema(title = "이력서 정보")
    private Long recruitId;
    @Schema(title = "성별")
    private GENDER gender;
    @Schema(title = "영어 이름")
    private String engName;
    @Schema(title = "이메일")
    private String email;
    @Schema(title = "주소")
    private String addr;
    @Schema(title = "상세주소")
    private String addrDetail;
    @Schema(title = "우편번호")
    private String zip;
    @Schema(title = "병역여부")
    private CHECK military;
    @Schema(title = "사진")
    private String pic;
    @Schema(title = "작성일자")
    private LocalDate creDate;
    @Schema(title = "등록상태")
    private STATE state;
    @Schema(title = "교육")
    private List<Education> educations;
    @Schema(title = "대외활동")
    private List<Activity> activities;
    @Schema(title = "자격증")
    private List<License> licenses;
    @Schema(title = "자기소개서")
    private List<Info> info;

    @Builder
    public ResumeJoinDTO(Long resumeId, Long userId, Long recruitId, GENDER gender, String engName, String email,
            String addr, String addrDetail, String zip, CHECK military, String pic, LocalDate creDate, STATE state,
            List<Education> educations, List<Activity> activities, List<License> licenses, List<Info> info) {
        this.resumeId = resumeId;
        this.userId = userId;
        this.recruitId = recruitId;
        this.gender = gender;
        this.engName = engName;
        this.email = email;
        this.addr = addr;
        this.addrDetail = addrDetail;
        this.zip = zip;
        this.military = military;
        this.pic = pic;
        this.creDate = creDate;
        this.state = state;
        this.educations = educations;
        this.activities = activities;
        this.licenses = licenses;
        this.info = info;
    }

//    public Resume toEntity(UserRepository userRepository){
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new GlobalException(CODE.USER_NOT_FOUND));
//        return Resume.builder().resumeId(resumeId).user(user).recruit(null).gender(gender).engName(engName).email(email)
//                .addr(addr).addrDetail(addrDetail).zip(zip).military(military).pic(pic).creDate(creDate).state(state).build();
//    }
//    public Resume toEntity(RecruitRepository recruitRepository){
//        Recruit recruit = recruitRepository.findById(recruitId)
//                .orElseThrow(() -> new GlobalException(CODE.RECRUIT_NOT_FOUND));
//        return Resume.builder().resumeId(resumeId).user(null).recruit(recruit).gender(gender).engName(engName).email(email)
//                .addr(addr).addrDetail(addrDetail).zip(zip).military(military).pic(pic).creDate(creDate).state(state).build();
//    }
//    public Resume toEntity(UserRepository userRepository, RecruitRepository recruitRepository){
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new GlobalException(CODE.USER_NOT_FOUND));
//        Recruit recruit = recruitRepository.findById(recruitId)
//                .orElseThrow(() -> new GlobalException(CODE.RECRUIT_NOT_FOUND));
//        return Resume.builder().resumeId(resumeId).user(user).recruit(recruit).gender(gender).engName(engName).email(email)
//                .addr(addr).addrDetail(addrDetail).zip(zip).military(military).pic(pic).creDate(creDate).state(state).build();
//    }

}
