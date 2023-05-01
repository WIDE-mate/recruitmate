package com.recruit.systemmate.util;

import com.recruit.systemmate.enums.ERROR;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.Map;

public class ResponseUtil {

    public static ResponseEntity<Map<String, Object>> ok (Object result){
        return ResponseEntity.ok(Collections.singletonMap("result", result));
    }

    public static ResponseEntity<Map<String, Object>> trueToOne (boolean result){
        return ResponseEntity.ok(Collections.singletonMap("result",result ? "1" : "0"));
    }

    public static ResponseEntity<Map<String, Object>> err (ERROR error, String msg){
        return ResponseEntity.ok(Collections.singletonMap("error", "{ code='"+error.getTitle()+"', msg='"+msg+"'}"));
    }

    public static ResponseEntity<Map<String, Object>> errs (ERROR error, Map<String,String> msg){
        return ResponseEntity.ok(Collections.singletonMap("error", "{ code='"+error.getTitle()+"', msg='"+msg+"'}"));
    }

}
