package com.payment.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/mock-gateway")
public class MockGatewaycontroller {

    @PostMapping("/success")
    public Map<String, Object> success() {
        return Map.of(
                "status", "SUCCESS",
                "message", "Mock payment successful"
        );
    }

    @PostMapping("/failure")
    public Map<String, Object> failure() {
        return Map.of(
                "status", "FAILED",
                "message", "Mock payment failed"
        );
    }
}
