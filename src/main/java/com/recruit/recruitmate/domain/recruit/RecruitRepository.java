package com.recruit.recruitmate.domain.recruit;

import com.recruit.usermate.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruitRepository extends JpaRepository<Recruit,String> {
}
