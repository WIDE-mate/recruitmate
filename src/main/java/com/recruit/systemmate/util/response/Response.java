package com.recruit.systemmate.util.response;

import com.recruit.systemmate.enums.Code;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Response{
    private Boolean success;
    private Integer code;
    private String message;

    @Builder
    public Response(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public static Response of(Boolean success, Code code){
        return Response.builder().success(success).code(code.getCode()).message(code.getMessage()).build();
    }

    public static Response of(Boolean success, Code err, Exception e){
        return Response.builder().success(success).code(err.getCode()).message(err.getMessage(e)).build();
    }

    public static Response of(Boolean success, Code err, String msg){
        return Response.builder().success(success).code(err.getCode()).message(err.getMessage(msg)).build();
    }

}
