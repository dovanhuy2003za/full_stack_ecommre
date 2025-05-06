package com.huy.backend.dto.reponse;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiReponse <T>{
    private int code=200;
    private String message;
    private T result;
    
    
}
