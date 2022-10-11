package com.example.hydraservice.model;

import lombok.Data;

@Data
public class HydraBasicForm {
    private String username;
    private String password;
    private String protocol;
    private String httpForm;
}
