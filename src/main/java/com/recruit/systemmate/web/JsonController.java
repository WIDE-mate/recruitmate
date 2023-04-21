package com.recruit.systemmate.web;

import com.recruit.systemmate.util.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/json")
public class JsonController {

    @GetMapping("/path")
    private ResponseEntity<Map<String, Object>> path(){
        return ResponseUtil.ok(null);
    }

}
