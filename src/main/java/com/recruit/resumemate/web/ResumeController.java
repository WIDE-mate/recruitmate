package com.recruit.resumemate.web;

import com.recruit.resumemate.service.resume.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ResumeController {

    private final ResumeService resumeService;

}
