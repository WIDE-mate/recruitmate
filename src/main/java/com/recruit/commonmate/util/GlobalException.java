package com.recruit.commonmate.util;

import com.recruit.commonmate.enums.CODE;
import lombok.Getter;

@Getter
public class GlobalException extends RuntimeException{
    private final CODE code;

    public GlobalException(){
        super(CODE.INTERNAL_ERROR.getMessage());
        this.code = CODE.INTERNAL_ERROR;
    }

    public GlobalException(CODE code){
        super(code.getMessage());
        this.code = code;
    }

    public GlobalException(String msg){
        super(msg);
        this.code = CODE.INTERNAL_ERROR;
    }

    public GlobalException(CODE code, String msg){
        super(msg);
        this.code = code;
    }

}
