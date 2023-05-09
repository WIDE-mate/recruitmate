package com.recruit.recruitmate.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecruitRedirectController {

    @GetMapping("/recruitPage")
    private String recruitPage(){
        return "recruitPage";
    }
}
