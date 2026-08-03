package com.payment.demo.controller;

import com.payment.demo.dto.CallbackrequestDto;
import com.payment.demo.entity.Payment;
import com.payment.demo.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments/callback")
@RequiredArgsConstructor
public class callbackcontroller {

    private final PaymentService paymentService;

    @PostMapping
    public Payment callback(@Valid @RequestBody CallbackrequestDto request) {

        return paymentService.updateStatus(
                request.getPaymentId(),
                request.getStatus()
        );
    }
}
