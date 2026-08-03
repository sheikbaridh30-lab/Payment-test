package com.payment.demo.controller;

import com.payment.demo.dto.Paymentresponsedto;
import com.payment.demo.dto.Paymentrequestdto;
import com.payment.demo.entity.Payment;
import com.payment.demo.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public Paymentresponsedto createPayment(@Valid @RequestBody Paymentrequestdto request) {
        return paymentService.createPayment(request);
    }

    @GetMapping("/{id}")
    public Payment getPayment(@PathVariable Long id) {
        return paymentService.getPayment(id);
    }
}