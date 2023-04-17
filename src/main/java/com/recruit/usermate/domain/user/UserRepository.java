package com.recruit.usermate.domain.user;

import com.recruit.usermate.web.dto.LoginDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,String> {
//    @Query("SELECT m.user_id, m.grade FROM User m WHERE m.id = :id AND m.password = :password")
//    LoginDTO login(@Param("id") String id, @Param("password") String password);
}
