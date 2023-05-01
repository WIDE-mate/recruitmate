package com.recruit.systemmate.handler;

import com.recruit.systemmate.enums.ERROR;
import com.recruit.systemmate.handler.exception.HttpSessionUserNotFoundException;
import com.recruit.systemmate.util.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@RestControllerAdvice(basePackages = "com.recruit.usermate.web", annotations = RestController.class)
public class HttpSessionExceptionHandler {

    @ExceptionHandler(value = {HttpSessionRequiredException.class})
    protected ResponseEntity<Map<String, Object>> httpSessionRequiredException(HttpSessionRequiredException ex, WebRequest request){
        return ResponseUtil.err(ERROR.ERR_SESSION,ex.getMessage());
    }

    @ExceptionHandler(value = {HttpSessionUserNotFoundException.class})
    protected ResponseEntity<Map<String, Object>> httpSessionUserNotFoundException(HttpSessionUserNotFoundException ex, WebRequest request){
        return ResponseUtil.err(ERROR.ERR_SESSION,ex.getMessage());
    }
}
