package com.recruit.systemmate.handler;

import com.recruit.systemmate.enums.ERROR;
import com.recruit.systemmate.handler.exception.DuplicateIDException;
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

    @ExceptionHandler(value = UserNotFoundException.class)
    protected ResponseEntity<Map<String ,Object>> userNotFoundException(UserNotFoundException ex, WebRequest request){
        return ResponseUtil.err(ERROR.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(value = {DuplicateIDException.class})
    protected ResponseEntity<Map<String, Object>> duplicateIDException(DuplicateIDException ex, WebRequest request){
        return ResponseUtil.err(ERROR.DUPLICATE_ID,ex.getMessage());
    }
}
