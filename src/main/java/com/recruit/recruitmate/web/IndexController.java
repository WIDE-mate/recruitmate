package com.recruit.recruitmate.web;

import com.recruit.recruitmate.config.auth.Login;
import com.recruit.recruitmate.config.auth.dto.SessionMember;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(@Login SessionMember member){
        if (member == null || member.getId() == null) return "redirect:/login";
        return "./template/main.html";
    }
}
