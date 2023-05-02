package com.recruit.systemmate.handler;

import com.recruit.systemmate.enums.ERROR;
import com.recruit.systemmate.util.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestControllerAdvice(annotations = RestController.class)
public class GrobalExceptionHandler {

    @ExceptionHandler(value = {MissingServletRequestParameterException.class, HttpMessageNotReadableException.class})
    protected ResponseEntity<Map<String, Object>> badRequestExceptions(Exception ex, WebRequest request) {
        return ResponseUtil.err(ERROR.INVALID_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    protected ResponseEntity<Map<String ,Object>> sqlIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex, WebRequest request){
        return ResponseUtil.err(ERROR.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    protected ResponseEntity<Map<String, Object>> methodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request){
        BindingResult bindingResult = ex.getBindingResult();
        List<String> errors = new ArrayList<>();
        String msg = "알 수 없는 유효성 에러입니다.";

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            String errCode = fieldError.getCode();
            String defaultMessage = fieldError.getDefaultMessage();

            if (errCode == null)
                errors.add(msg);
            else
                errors.add(defaultMessage);

        }

        if (!errors.isEmpty())
            return ResponseUtil.err(ERROR.UN_ENTITY, errors);
        else
            return ResponseUtil.err(ERROR.UNKNOWN_ERROR, msg);

    }

}
