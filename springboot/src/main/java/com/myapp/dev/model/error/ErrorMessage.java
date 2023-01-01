package com.myapp.dev.model.error;

public enum ErrorMessage {

    NOT_FOUND("Không tìm thấy bản ghi %s từ id = %s");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
