package com.recruit.systemmate.handler;

import com.recruit.systemmate.enums.ERROR;
import com.recruit.systemmate.util.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice(annotations = RestController.class)
public class GrobalExceptionHandler {

    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    protected ResponseEntity<Map<String ,Object>> persistentObjectException(SQLIntegrityConstraintViolationException ex, WebRequest request){
        return ResponseUtil.err(ERROR.DB_ERR, ex.getMessage());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    protected ResponseEntity<Map<String, Object>> userArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request){
        BindingResult bindingResult = ex.getBindingResult();
        Map<String,String> errors = new HashMap<>();
        String msg = "알 수 없는 유효성 에러입니다.(알려주세요)";

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            String errCode = fieldError.getCode();
            String defaultMessage = fieldError.getDefaultMessage();

            if (errCode == null) {
                errors.put(ERROR.UNKNOWN.getTitle(), msg);
                continue;
            }

            switch (errCode) {
                case "NotEmpty":
                    errors.put(ERROR.NOT_EMPTY.getTitle(), defaultMessage);
                    break;
                case "Size":
                    errors.put(ERROR.MAX_VALUE.getTitle(), defaultMessage);
                    break;
                case "Pattern":
                    errors.put(ERROR.PATTERN.getTitle(), defaultMessage);
                    break;
                case "Email":
                    errors.put(ERROR.EMAIL.getTitle(), defaultMessage);
                    break;
                default:
                    errors.put(ERROR.UNKNOWN.getTitle(), defaultMessage);
                    break;
            }
        }

        if (!errors.isEmpty())
            return ResponseUtil.errs(ERROR.ERROR, errors);
        else
            return ResponseUtil.err(ERROR.UNKNOWN, msg);

    }

}
