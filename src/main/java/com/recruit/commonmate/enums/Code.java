package com.recruit.commonmate.enums;

import com.recruit.commonmate.GlobalException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;

@Getter
public enum Code {
    // success
    OK(0, HttpStatus.OK,"ok"),

    // 4xx
    BAD_REQUEST(10000, HttpStatus.BAD_REQUEST, "Bad request"),
    ERR_PARAMETER(10001,HttpStatus.BAD_REQUEST,"요청에서 필요한 파라미터 누락"),
    NOT_READ(10002,HttpStatus.BAD_REQUEST,"서버에서 처리될 수 없는 잘못된 요청"),
    ERR_SQL(10003,HttpStatus.BAD_REQUEST,"SQL 구문오류"),
    INVALID(10004,HttpStatus.BAD_REQUEST,"유효성 오류"),

    USER_NOT_FOUND(11001, HttpStatus.NOT_FOUND, "존재하지 않는 유저입니다."),
    DUPLICATE_ID(11002,HttpStatus.CONFLICT,"중복된 아이디입니다."),
    NOT_SESSION(11003,HttpStatus.UNAUTHORIZED,"세션 혹은 로그인키가 존재하지 않습니다."),
    NOT_IN_USER(11004,HttpStatus.UNAUTHORIZED,"세션에 유저정보가 존재하지 않습니다."),

    // 5xx
    INTERNAL_ERROR(20000, HttpStatus.INTERNAL_SERVER_ERROR, "Internal error");

    private final Integer code;
    private final HttpStatus status;
    private final String message;

    Code(Integer code, HttpStatus status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }

    public String getMessage(String message) {
        return Optional.ofNullable(message)
                .filter(Predicate.not(String::isBlank))
                .orElse(this.getMessage());
    }

    public String getMessage(Throwable e){
        return this.getMessage(this.getMessage() + " - " + e.getMessage());
    }

    public static Code valueOf(HttpStatus status){
        if (status == null)
            throw new GlobalException("status가 존재하지 않습니다.");
        return Arrays.stream(values())
                .filter(errCode -> errCode.getStatus() == status)
                .findFirst()
                .orElseGet(()->{
                    if (status.is4xxClientError())
                        return null;
                    else if(status.is5xxServerError())
                        return Code.INTERNAL_ERROR;
                    else
                        return Code.OK;
                });
    }

}
