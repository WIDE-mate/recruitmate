package com.recruit.systemmate.util;

import com.recruit.systemmate.enums.ERROR;
import com.recruit.systemmate.util.response.Response;
import com.recruit.systemmate.util.response.DataResponse;
import com.recruit.usermate.web.dto.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {

    public static ResponseEntity<Map<String, Object>> ok (Object result){
        return ResponseEntity.ok(Collections.singletonMap("result",result));
    }

    public static ResponseEntity<Map<String, Object>> trueToOne (boolean result){
        return ResponseEntity.ok(Collections.singletonMap("result",result ? "1" : "0"));
    }

    public static ResponseEntity<Map<String, Object>> err (ERROR error, Object msg){
        Map<String,Object> map = new HashMap<>();
        map.put("error",error.getTitle());
        map.put("msg",msg);
        return ResponseEntity.ok(Collections.singletonMap("error", map));
    }

}
