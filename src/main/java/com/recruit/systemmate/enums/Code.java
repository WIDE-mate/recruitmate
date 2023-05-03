package com.recruit.systemmate.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;

@Getter
public enum Code {
    OK(0, HttpStatus.OK,"ok");

    private Integer code;
    private HttpStatus status;
    private String message;

    Code(Integer code, HttpStatus status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }

    public String getMessage(String s) {
        return Optional.ofNullable(this.message)
                .filter(Predicate.not(String::isBlank))
                .orElse(this.getMessage());
    }

    public String getMessage(Throwable e){
        return this.getMessage(this.getMessage() + " - " + e.getMessage());
    }

    public static Code valueOf(HttpStatus status){
//        if (status == null)
//            throw new G
        return Arrays.stream(values())
                .filter(errCode -> errCode.getStatus() == status)
                .findFirst()
                .orElseGet(()->{
                    if (status.is4xxClientError())
                        return null;
                    else if(status.is5xxServerError())
                        return null;
                    else return Code.OK;
                });
    }

}
