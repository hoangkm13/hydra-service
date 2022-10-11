package com.example.hydraservice.controller.request;

import lombok.Data;

@Data
public class HydraRequest {
    private String username;
    private String password;
    private String ipAddress;
    private Integer port;
    private String url;
    private String protocol;
    private String httpForm;
}
