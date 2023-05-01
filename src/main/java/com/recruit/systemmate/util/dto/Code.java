package com.recruit.systemmate.util.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Code {
    private String err;
    private String msg;

    @Builder
    public Code(String err, String msg) {
        this.err = err;
        this.msg = msg;
    }
}
