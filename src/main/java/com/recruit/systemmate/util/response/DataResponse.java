package com.recruit.systemmate.util.response;

import com.recruit.systemmate.enums.Code;
import com.recruit.usermate.web.dto.UserDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DataResponse<T> extends Response{

    private T data;
//
//    @Builder
//    private DataResponse(T data, String msg){
//        super(true, Code.OK.getCode(),msg);
//        this.data = data;
//    }
//
//    public static <T> DataResponse<T> of(T data){
//        return DataResponse.builder().build();
//    }
//
//    public static Response of(Boolean success, Code err, Exception e){
//        return Response.builder().success(success).code(err.getCode()).message(err.getMessage(e)).build();
//    }
//
//    public static Response of(Boolean success, Code err, String msg){
//        return Response.builder().success(success).code(err.getCode()).message(err.getMessage(msg)).build();
//    }

}
