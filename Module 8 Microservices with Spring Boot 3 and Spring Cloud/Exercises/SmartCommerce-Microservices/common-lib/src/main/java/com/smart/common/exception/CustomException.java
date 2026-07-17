package com.smart.common.exception;

public class CustomException extends RuntimeException {

    private String errorCode;
    private int status;

    public CustomException(String message) {
        super(message);
        this.status = 500;
    }

    public CustomException(String message, int status) {
        super(message);
        this.status = status;
    }

    public CustomException(String message, String errorCode, int status) {
        super(message);
        this.errorCode = errorCode;
        this.status = status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public int getStatus() {
        return status;
    }
}