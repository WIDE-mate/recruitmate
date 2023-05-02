package com.recruit.systemmate.handler;

import com.recruit.systemmate.enums.ERROR;
import com.recruit.systemmate.handler.exception.DuplicateIDException;
import com.recruit.systemmate.handler.exception.HttpSessionRequiredException;
import com.recruit.systemmate.handler.exception.HttpSessionUserNotFoundException;
import com.recruit.systemmate.handler.exception.UserNotFoundException;
import com.recruit.systemmate.util.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@RestControllerAdvice(basePackages = "com.recruit.usermate.web", annotations = RestController.class)
public class UserExceptionHandler {

    @ExceptionHandler(value = {HttpSessionRequiredException.class})
    protected ResponseEntity<Map<String, Object>> httpSessionRequiredException(HttpSessionRequiredException ex, WebRequest request){
        return ResponseUtil.err(ERROR.UN_AUTH,ex.getMessage());
    }

    @ExceptionHandler(value = {HttpSessionUserNotFoundException.class})
    protected ResponseEntity<Map<String, Object>> httpSessionUserNotFoundException(HttpSessionUserNotFoundException ex, WebRequest request){
        return ResponseUtil.err(ERROR.UN_AUTH,ex.getMessage());
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    protected ResponseEntity<Map<String ,Object>> userNotFoundException(UserNotFoundException ex, WebRequest request){
        return ResponseUtil.err(ERROR.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(value = {DuplicateIDException.class})
    protected ResponseEntity<Map<String, Object>> duplicateIDException(DuplicateIDException ex, WebRequest request){
        return ResponseUtil.err(ERROR.CONFLICT,ex.getMessage());
    }
}
