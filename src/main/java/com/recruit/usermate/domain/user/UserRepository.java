package com.recruit.usermate.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,String> {
    @Query("SELECT m.id FROM User m WHERE m.id = :id AND m.password = :password")
    String login(@Param("id") String id, @Param("password") String password);
}
