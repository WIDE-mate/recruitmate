package com.recruit.commonmate.dto;

import com.recruit.commonmate.enums.Code;

public class ResponseError extends Response{

    public ResponseError(Code err) {
        super(false, err.getCode(), err.getMessage());
    }

    public ResponseError(Code err, Exception ex) {
        super(false, err.getCode(), ex.getMessage());
    }

    public ResponseError(Code err, String msg) {
        super(false, err.getCode(), msg);
    }

    public static ResponseError of(Code err){
        return new ResponseError(err);
    }

    public static ResponseError of(Code err, Exception ex){
        return new ResponseError(err,ex);
    }

    public static ResponseError of(Code err, String message){
        return new ResponseError(err,message);
    }

}
