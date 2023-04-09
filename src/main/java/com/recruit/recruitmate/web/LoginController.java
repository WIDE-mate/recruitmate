package com.recruit.recruitmate.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class LoginController {

    private final HttpSession httpSession;

    @GetMapping("/login")
    public String login(){
        return "login.html";
    }

    @GetMapping("/logout")
    public String logout(){
        httpSession.invalidate();
        return "redirect:/login";
    }
}
