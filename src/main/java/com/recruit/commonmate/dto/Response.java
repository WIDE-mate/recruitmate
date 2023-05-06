package com.recruit.commonmate.dto;

import com.recruit.commonmate.enums.Code;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "응답 DTO")
@Getter
@ToString
@AllArgsConstructor
public class Response{
    @Schema(title = "성공 유무")
    private final Boolean success;
    @Schema(title = "응답 코드")
    private final Integer code;
    @Schema(title = "메세지")
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
