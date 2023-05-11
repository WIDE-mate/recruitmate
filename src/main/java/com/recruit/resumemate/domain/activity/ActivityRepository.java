package com.recruit.resumemate.domain.activity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, ActivityId> {
}
