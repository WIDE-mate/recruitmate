package com.recruit.systemmate.web;

import com.recruit.systemmate.config.auth.Login;
import com.recruit.systemmate.config.auth.dto.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(){
        return "main";
    }

}
