package com.example.springbootapi.controller;

import com.example.springbootapi.exception.BusinessCode;
import com.example.springbootapi.exception.BusinessException;
import com.example.springbootapi.model.BaseResponse;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class HttpErrorHandler {

//    @ExceptionHandler({MethodArgumentNotValidException.class})
//    public List<Object> handleBeanValidation(MethodArgumentNotValidException manv){
//        List<Object> errors = new ArrayList<>();
//        for(ObjectError error : manv.getBindingResult().getAllErrors()){
//            errors.add(error.getDefaultMessage());
//        }
//        return errors;
//    }
//
//    @ExceptionHandler({BusinessException.class})
//    public Object handleBusinessException(BusinessException be){
//        return be.getCode();
//    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public BaseResponse<Object> handleBeanValidation(MethodArgumentNotValidException manv) {
        List<Object> errors = new ArrayList<>();
        for (ObjectError error : manv.getBindingResult().getAllErrors()) {
            errors.add(error.getDefaultMessage());
        }

        String formatErrors = errors.stream().map(Object::toString).collect(Collectors.joining(", "));
        BusinessException exception = new BusinessException(BusinessCode.DATA_NOT_VALID);
        return BaseResponse.error(exception, formatErrors);
    }

    @ExceptionHandler({BusinessException.class})
    public BaseResponse<Object> handleBusinessException(BusinessException be) {
        return BaseResponse.error(be, null);
    }

}
