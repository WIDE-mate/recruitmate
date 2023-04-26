package com.recruit.usermate.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserRedirectController {

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/sign")
    public String signPage(){
        return "sign";
    }

    @GetMapping("/myPage")
    public String myPage(){
        return "myPage";
    }

}
