package com.example.schedule.global.globalEnum;

import lombok.Getter;

@Getter
public enum HttpStatusEnum {

    OK(200, "OK"),
    CREATE(201, "Created"),
    FAIL(401, "Fail"),
    NOT_FOUND(404, "Not Found");

    private final Integer stateCode;
    private final String message;

    HttpStatusEnum(Integer stateCode, String message) {
        this.stateCode = stateCode;
        this.message = message;
    }
}
