package com.example.springbootapi.model;

import com.example.springbootapi.exception.BusinessCode;
import com.example.springbootapi.exception.BusinessException;

public class BaseResponse<T> {
    private String code;
    private String message;
    private String errors;
    private T data;

    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(
                BusinessCode.SUCCESS.toString(),
                BusinessCode.SUCCESS.getMessage(),
                null,
                data
        );
    }

    public static <T> BaseResponse<T> error(BusinessException be, String errors) {
        return new BaseResponse<>(
                be.getCode().toString(),
                be.getMessage(),
                errors,
                null
        );
    }

    public BaseResponse() {
    }

    private BaseResponse(String code, String message, String errors, T data) {
        this.code = code;
        this.message = message;
        this.errors = errors;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
