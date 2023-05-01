package com.recruit.systemmate.handler.exception;

public class HttpSessionUserNotFoundException extends RuntimeException{

    public HttpSessionUserNotFoundException(){
        super("No user info exists in HttpSession");
    }

}
