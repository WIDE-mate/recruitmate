package com.recruit.commonmate.response;

import com.recruit.commonmate.enums.CODE;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Schema(description = "응답 성공 DTO")
@Getter
public class ResponseData<T> extends Response{

    @Schema(title = "응답 데이터")
    private final T data;

    private ResponseData(T data){
        super(true, CODE.OK.getCode(), CODE.OK.getMessage());
        this.data = data;
    }

    private ResponseData(T data, String msg){
        super(true, CODE.OK.getCode(),msg);
        this.data = data;
    }

    public static <T> ResponseData<T> of(T data){
        return new ResponseData<>(data);
    }

    public static <T> ResponseData<T> of(T data, String message){
        return new ResponseData<>(data,message);
    }

    public static <T> ResponseData<T> empty(){
        return new ResponseData<>(null);
    }

}
