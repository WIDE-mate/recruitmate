package com.recruit.commonmate;

import com.recruit.commonmate.enums.Code;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class GeneralException extends RuntimeException{
    private final Code code;

    public GeneralException(){
        super(Code.INTERNAL_ERROR.getMessage());
        this.code = Code.INTERNAL_ERROR;
    }

    public GeneralException(Code code){
        super(code.getMessage());
        this.code = code;
    }

    public GeneralException(String msg){
        super(msg);
        this.code = Code.INTERNAL_ERROR;
    }

    public GeneralException(Code code, String msg){
        super(msg);
        this.code = code;
    }

}
