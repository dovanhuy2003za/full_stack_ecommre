package com.huy.backend.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.huy.backend.dto.reponse.ApiReponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    @SuppressWarnings("rawtypes")
    @ExceptionHandler(value = RuntimeException.class)
    ResponseEntity<ApiReponse> handleRuntimeException(RuntimeException e) {
        ApiReponse apiReponse = new ApiReponse();
        apiReponse.setCode(500);
        apiReponse.setMessage(e.getMessage());

        return ResponseEntity.badRequest().body(apiReponse);
    }
    @ExceptionHandler(value  =MethodArgumentNotValidException.class)
    ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest().body(e.getFieldError().getDefaultMessage());
    }   
    @SuppressWarnings("rawtypes")
    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiReponse> handleAppException(AppException e) {
        ErrorCode errorCode = e.getErrorCode();
        ApiReponse apiReponse = new ApiReponse();
        apiReponse.setCode(errorCode.getCode());
        apiReponse.setMessage(errorCode.getMessage());

        return ResponseEntity.badRequest().body(apiReponse);
    }     
}
