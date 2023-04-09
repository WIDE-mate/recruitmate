package com.recruit.recruitmate.service.member;

import com.recruit.recruitmate.domain.member.MemberRepository;
import com.recruit.recruitmate.web.dto.LoginDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Boolean login(LoginDTO loginDTO){
        return !Objects.isNull(memberRepository.login(loginDTO.getId(), loginDTO.getPassword()));
    }

}
