package com.recruit.systemmate.enums;

import lombok.Getter;

@Getter
public enum ERROR {

    INVALID_REQUEST("400 Bad Request"),
    UN_AUTH("401 Unauthorized"),
    NOT_FOUND("404 Not Found"),
    CONFLICT("409 Conflict"),
    UN_ENTITY("422 UnProcessable Entity"),

    INTERNAL_SERVER_ERROR("500 Internal Server Error"),

    UNKNOWN_ERROR("Unknown Error");

    private String title;

    ERROR(String title){
        this.title = title;
    }
}
