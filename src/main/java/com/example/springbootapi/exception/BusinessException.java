package com.example.springbootapi.exception;

public class BusinessException extends RuntimeException {
    private final BusinessCode code;

    public BusinessException(BusinessCode code) {
        this.code = code;
    }

    public BusinessCode getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return code.getMessage();
    }

}

