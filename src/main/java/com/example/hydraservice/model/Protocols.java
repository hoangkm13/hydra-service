package com.example.hydraservice.model;

import lombok.Getter;

@Getter
public enum Protocols {
    HTTP_GET_FORM("HTTP_GET_FORM", "http-get-form"),
    HTTP_POST_FORM("HTTP_POST_FORM", "http-post-form");

    private final String message;
    private final String code;

    Protocols(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
