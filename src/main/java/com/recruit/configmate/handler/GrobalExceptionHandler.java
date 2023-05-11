package com.recruit.configmate.handler;

import com.recruit.commonmate.enums.CODE;
import com.recruit.commonmate.util.GlobalException;
import com.recruit.commonmate.response.ResponseError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice(annotations = RestController.class)
public class GrobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = GlobalException.class)
    protected ResponseEntity<Object> globalException(GlobalException ex, WebRequest request){
        return handleExceptionInternal(ex, ex.getCode(), request);
    }

    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    protected ResponseEntity<Object> sqlIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex, WebRequest request){
        return handleExceptionInternal(ex, CODE.ERR_SQL, request);
    }

    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<Object> exception(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, CODE.INTERNAL_ERROR,request);
    }

    private ResponseEntity<Object> handleExceptionInternal(Exception ex, CODE err, WebRequest request){
        return handleExceptionInternal(ex, err, HttpHeaders.EMPTY, err.getStatus(),request);
    }

    private ResponseEntity<Object> handleExceptionInternal(Exception ex, CODE err, HttpHeaders headers, HttpStatus status, WebRequest request){
        return super.handleExceptionInternal(
                ex, ResponseError.of(err, err.getMessage(ex)), headers, status, request
        );
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleExceptionInternal(ex, CODE.valueOf(status), request);
    }

}
