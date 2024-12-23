package com.yeowon.demo.exception.errorResponse;

import lombok.Getter;

@Getter
public class ErrorResult {
    private final int statusCode;
    private final String message;

    public ErrorResult(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}