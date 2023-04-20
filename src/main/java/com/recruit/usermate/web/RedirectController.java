package com.recruit.usermate.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/sign")
    public String sign(){
        return "sign";
    }

    @GetMapping("/myPage")
    public String myPage(){
        return "myPage";
    }

}
