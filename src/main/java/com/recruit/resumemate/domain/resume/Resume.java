package com.recruit.resumemate.domain.resume;

import com.recruit.commonmate.comcode.enums.GENDER;
import com.recruit.commonmate.comcode.enums.STATE;
import com.recruit.commonmate.enums.CHECK;
import com.recruit.recruitmate.domain.recruit.Recruit;
import com.recruit.resumemate.domain.activity.Activity;
import com.recruit.resumemate.domain.education.Education;
import com.recruit.usermate.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resumeId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "recruit_id", nullable = false)
    private Recruit recruit;

    @Enumerated(EnumType.STRING)
    private GENDER gender;

    private String engName;
    private String email;
    private String addr;
    private String addrDetail;
    private String zip;

    @Enumerated(EnumType.STRING)
    private CHECK military;

    private String pic;

    private LocalDate creDate;

    @Enumerated(EnumType.STRING)
    private STATE state;

    @OneToMany
    private List<Education> educations;
    @OneToMany
    private List<Activity> activities;

    @Builder
    public Resume(Long resumeId, User user, Recruit recruit, GENDER gender, String engName, String email,
            String addr, String addrDetail, String zip, CHECK military, String pic, LocalDate creDate, STATE state,
            List<Education> educations, List<Activity> activities) {
        this.resumeId = resumeId;
        this.user = user;
        this.recruit = recruit;
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
    }

}
