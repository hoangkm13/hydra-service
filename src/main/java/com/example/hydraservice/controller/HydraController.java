package com.example.hydraservice.controller;

import com.example.hydraservice.controller.request.HydraRequest;
import com.example.hydraservice.model.ApiResponse;
import com.example.hydraservice.service.HydraService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/v1/hydra")
@Log4j2
public class HydraController {

    private final HydraService hydraService;

    @PostMapping(value = "/start", produces = "application/json")
    public ApiResponse<String> login(@Valid @RequestBody HydraRequest hydraRequest) throws Exception {
        this.hydraService.callHydra(hydraRequest);
        return ApiResponse.successWithResult("success");

    }
}
