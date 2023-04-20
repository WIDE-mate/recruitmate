package com.recruit.usermate.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findByloginIdAndPassword(String loginId, String password);
    boolean existsByloginId(String loginId);
}
