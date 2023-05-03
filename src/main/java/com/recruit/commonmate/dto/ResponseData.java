package com.recruit.commonmate.dto;

import com.recruit.commonmate.enums.Code;
import lombok.Getter;

@Getter
public class ResponseData<T> extends Response{

    private final T data;

    private ResponseData(T data){
        super(true, Code.OK.getCode(),Code.OK.getMessage());
        this.data = data;
    }

    private ResponseData(T data, String msg){
        super(true, Code.OK.getCode(),msg);
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
