package com.zosh.payload.response;

public class ApiResponse {

    private String message;

    // All-arguments constructor
    public ApiResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}