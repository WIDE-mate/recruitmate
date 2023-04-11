package com.recruit.systemmate.web;

import com.recruit.systemmate.config.auth.Login;
import com.recruit.systemmate.config.auth.dto.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(@Login SessionUser user){
        if (user == null || user.getId() == null) return "redirect:/login";
        return "main";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
