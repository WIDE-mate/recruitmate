package com.recruit.usermate.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByloginId(String loginId);
    boolean existsByloginId(String loginId);
}
