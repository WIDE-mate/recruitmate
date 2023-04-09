package com.recruit.recruitmate.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member,String> {
    @Query("SELECT m.id FROM Member m WHERE m.id = :id AND m.password = :password")
    String login(@Param("id") String id, @Param("password") String password);
}
