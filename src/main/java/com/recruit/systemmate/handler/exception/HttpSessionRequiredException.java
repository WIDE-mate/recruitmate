package com.recruit.systemmate.handler.exception;

public class HttpSessionRequiredException extends RuntimeException{
    public HttpSessionRequiredException(){
        super("세션이 존재하지 않거나 세션안에 로그인키가 없습니다.");
    }
}
