package com.recruit.commonmate.dto;

import com.recruit.commonmate.enums.Code;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
public class Response{
    private final Boolean success;
    private final Integer code;
    private final String message;

    public static Response of(Boolean success, Code code){
        return new Response(success, code.getCode(), code.getMessage());
    }

    public static Response of(Boolean success, Code err, Exception e){
        return new Response(success,err.getCode(),err.getMessage(e));
    }

    public static Response of(Boolean success, Code err, String msg){
        return new Response(success,err.getCode(),err.getMessage(msg));
    }

}
