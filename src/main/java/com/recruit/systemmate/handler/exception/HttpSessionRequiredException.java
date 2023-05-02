package com.recruit.systemmate.handler.exception;

public class HttpSessionRequiredException extends RuntimeException{
    public HttpSessionRequiredException(){
        super("세션 혹은 로그인키가 존재하지 않습니다.");
    }
}
