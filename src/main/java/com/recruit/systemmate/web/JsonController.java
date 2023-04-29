package com.recruit.systemmate.web;

import com.recruit.systemmate.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;
import java.util.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/json")
public class JsonController {

    private final ApplicationContext context;

    @GetMapping("/path")
    private ResponseEntity<Map<String, Object>> path(){
        Map<String,String> paths = new HashMap<>();
        Map<String,Object> annotation = context.getBeansWithAnnotation(Controller.class);

        for(Object bean : annotation.values()){
            Class<?> classes = bean.getClass();
            RequestMapping requestMapping = AnnotationUtils.findAnnotation(classes, RequestMapping.class);
            for (Method method : classes.getMethods()){
                GetMapping getMapping = AnnotationUtils.findAnnotation(method, GetMapping.class);
                if (getMapping != null) paths.put(method.getName(), (requestMapping == null ? "" : requestMapping.value()[0]) + getMapping.value()[0]);
            }
        }
        return ResponseUtil.ok(paths);
    }

}
