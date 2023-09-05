package com.mongodbtest.Utils;

public class Responses<T> {
    private int statusCode;
    private String message;
    private T response;
    private boolean success;

    public Responses(int statusCode, String message, T response, boolean success) {
        this.statusCode = statusCode;
        this.message = message;
        this.response = response;
        this.success = success;
    }

    // Getters and setters

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
