package com.recruit.commonmate.enums;

import lombok.Getter;

@Getter
public enum CHECK {
    Y(true),
    N(false);

    private final Boolean result;

    CHECK(Boolean result){
        this.result = result;
    }

}
