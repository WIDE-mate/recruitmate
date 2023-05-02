package com.recruit.systemmate.util.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Response<T> {
    private String status;
    private String reason;
    private T data;

    @Builder
    public Response(String status, String reason, T data) {
        this.status = status;
        this.reason = reason;
        this.data = data;
    }
}
