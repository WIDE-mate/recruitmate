package com.recruit.systemmate.util;

import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.Map;

public class ResponseUtil {

    public static ResponseEntity<Map<String, Object>> ok (Object result){
        return ResponseEntity.ok(Collections.singletonMap("result",result));
    }

}
