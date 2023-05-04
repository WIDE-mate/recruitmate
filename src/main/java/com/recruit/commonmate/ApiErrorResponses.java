package com.recruit.commonmate;

import com.recruit.commonmate.dto.ResponseData;
import com.recruit.commonmate.dto.ResponseError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Operation(summary = "API", description = "API", responses = {
        @ApiResponse(responseCode = "200", description = "API 호출 성공",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        schema = @Schema(implementation = ResponseData.class))),
        @ApiResponse(responseCode = "404", description = "Not found", content = @Content),
        @ApiResponse(responseCode = "4XX, 5XX", description = "message 를 확인해주세요.", content = @Content(schema = @Schema(implementation = ResponseError.class)))
})
public @interface ApiErrorResponses {
}
