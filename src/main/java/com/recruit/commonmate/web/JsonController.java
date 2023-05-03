package com.recruit.commonmate.web;

import com.recruit.commonmate.dto.ResponseData;
import com.recruit.commonmate.util.EnumFactory;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.*;

@Tag(name = "시스템 Json", description = "시스템 정보 JSON 으로 return 하는 API 입니다.")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/json")
public class JsonController {

    private final ApplicationContext context;
    private final EnumFactory enums;

    /**
     * 경로 Json
     * 
     * @return 경로 형태의 Json 형태로 반환
     * */
    @Operation(summary = "경로 조회", description = "경로 조회 메서드 입니다.")
    @ApiResponse(responseCode = "200",  description = "조회 성공",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ResponseData.class)))
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
