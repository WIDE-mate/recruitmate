package com.recruit.usermate.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findByloginId(String loginId);
    boolean existsByloginId(String loginId);
}
