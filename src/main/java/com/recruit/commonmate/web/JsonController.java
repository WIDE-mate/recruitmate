package com.recruit.commonmate.web;

import com.recruit.commonmate.comcode.dto.EnumDTO;
import com.recruit.commonmate.response.ResponseData;
import com.recruit.commonmate.response.ResponseError;
import com.recruit.commonmate.util.Code;
import com.recruit.commonmate.comcode.EnumFactory;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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

    @Operation(summary = "경로 조회", description = "경로 조회 API")
    @GetMapping("/path")
    private ResponseData<Map<String,String>> path(){
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

    @Operation(summary = "공통코드 전체", description = "공통코드 전체 조회 API")
    @GetMapping("/code")
    private ResponseData<Map<String, List<EnumDTO>>> comCodeAll(){
        return ResponseData.of(enums.get());
    }

    @Operation(summary = "공통코드", description = "공통코드 조회 API")
    @GetMapping("/code/{code}")
    private ResponseData<List<EnumDTO>> comCode(@Parameter(name = "code", description = "코드 이름") @PathVariable String code){
        return ResponseData.of(enums.get(code.toUpperCase()));
    }

    @Operation(summary = "공통코드 이름", description = "공통코드 Code명 전체 조회 API")
    @GetMapping("/code/keys")
    private ResponseData<List<String>> codeKeys(){
        return ResponseData.of(enums.keys());
    }

    @GetMapping("/error")
    private ResponseError error(){
        return ResponseError.of(Code.INTERNAL_ERROR);
    }

}
