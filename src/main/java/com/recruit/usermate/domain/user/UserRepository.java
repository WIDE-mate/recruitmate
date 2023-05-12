package com.recruit.usermate.domain.user;

import com.recruit.usermate.web.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByLoginId(String loginId);
    boolean existsByLoginId(String loginId);
    List<UserDTO> findAllBy();
}
