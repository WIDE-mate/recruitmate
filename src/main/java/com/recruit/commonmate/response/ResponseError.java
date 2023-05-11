package com.recruit.commonmate.response;

import com.recruit.commonmate.enums.CODE;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Schema(description = "응답 실패 DTO")
@Getter
public class ResponseError extends Response{

    public ResponseError(CODE err) {
        super(false, err.getCode(), err.getMessage());
    }

    public ResponseError(CODE err, Exception ex) {
        super(false, err.getCode(), ex.getMessage());
    }

    public ResponseError(CODE err, String msg) {
        super(false, err.getCode(), msg);
    }

    public static ResponseError of(CODE err){
        return new ResponseError(err);
    }

    public static ResponseError of(CODE err, Exception ex){
        return new ResponseError(err,ex);
    }

    public static ResponseError of(CODE err, String message){
        return new ResponseError(err,message);
    }

}
