package com.ecommerce.ecommerce_api.exception;

public class StandardError {

    private Integer status;
    private String message;

    public StandardError(Integer status, String message){
        this.status = status;
        this.message = message;
    }

    public Integer getStatus(){
        return status;
    }

    public String getMessage(){
        return message;
    }
}
