package com.recruit.commonmate;

import com.recruit.commonmate.enums.Code;
import lombok.Getter;

@Getter
public class GlobalException extends RuntimeException{
    private final Code code;

    public GlobalException(){
        super(Code.INTERNAL_ERROR.getMessage());
        this.code = Code.INTERNAL_ERROR;
    }

    public GlobalException(Code code){
        super(code.getMessage());
        this.code = code;
    }

    public GlobalException(String msg){
        super(msg);
        this.code = Code.INTERNAL_ERROR;
    }

    public GlobalException(Code code, String msg){
        super(msg);
        this.code = code;
    }

}
