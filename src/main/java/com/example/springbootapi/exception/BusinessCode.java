package com.example.springbootapi.exception;

public enum BusinessCode {
    SUCCESS("Data berhasil didapatkan."),
    DATA_NOT_EXIST("Data tidak ditemukan."),
    DATA_NOT_VALID("Data field tidak sesuai dengan format."),
    DATA_ALREADY_EXIST("Data telah ada didalam sistem.");

    private final String message;

    BusinessCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
