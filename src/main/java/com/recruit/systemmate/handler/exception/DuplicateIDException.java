package com.recruit.systemmate.handler.exception;

public class DuplicateIDException extends RuntimeException {
    public DuplicateIDException(){
        super("아이디가 중복입니다.");
    }
}
