package com.recruit.commonmate.web;

import com.recruit.commonmate.dto.ResponseData;
import com.recruit.commonmate.util.EnumFactory;
import com.recruit.commonmate.ApiErrorResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.*;

@Tag(name = "시스템 Json", description = "시스템 정보 JSON 으로 반환 하는 API 입니다.")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/json")
public class JsonController {

    private final ApplicationContext context;
    private final EnumFactory enums;

    @ApiErrorResponses()
    @GetMapping("/path")
    private ResponseData<Object> path(){
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
        return ResponseData.of(paths);
    }

    /**
     * 공통코드 Json
     *
     * @return 모든 공통코드를 Json 형태로 반환
     * */
    @GetMapping("/code")
    private ResponseData<Object> comCodeAll(){
        return ResponseData.of(enums.get());
    }

    /**
     * 공통코드 Json
     *
     * @param code 공통코드명
     * @return 모든 공통코드를 Json 형태로 반환
     * */
    @GetMapping("/code/{code}")
    private ResponseData<Object> comCode(@PathVariable String code){
        return ResponseData.of(enums.get(code.toUpperCase()));
    }

    /**
     * 공통코드 key Json
     *
     * @return 공통코드의 key 값들을 Json 형태로 반환
     * */
    @GetMapping("/code/keys")
    private ResponseData<Object> codeKeys(){
        return ResponseData.of(enums.keys());
    }

}
