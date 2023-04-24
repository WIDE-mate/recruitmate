package com.recruit.commonmate.web;

import com.recruit.systemmate.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/json")
public class JsonController {

    private final RequestMappingHandlerMapping handlerMapping;

    @GetMapping("/path")
    private ResponseEntity<Map<String, Object>> path(){
        return null;
//        Map<RequestMappingInfo, HandlerMethod> mappings = handlerMapping.getHandlerMethods();
//        Map<String, String > jsonMappings = new HashMap<>();
//        for (RequestMappingInfo mapping : mappings.keySet()) {
//            if (mappings.get(mapping).getBeanType().equals(MainController.class))
//                jsonMappings.put(mapping.getPatternsCondition().getPatterns().iterator().next()
//                    , mappings.get(mapping).getMethod().getName());
//
//        }
//        return ResponseUtil.ok(Objects.isNull(jsonMappings));
    }

}
