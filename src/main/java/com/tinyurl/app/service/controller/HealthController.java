package com.tinyurl.app.service.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HealthController {
    
    @GetMapping("/health")
    public String healthCheck() {
        return "OK";
    }
}
