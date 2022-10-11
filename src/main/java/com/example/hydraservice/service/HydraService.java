package com.example.hydraservice.service;

import com.example.hydraservice.controller.request.HydraRequest;

public interface HydraService {
    void callHydra(HydraRequest hydraRequest) throws Exception;
}
