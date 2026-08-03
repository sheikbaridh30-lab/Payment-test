package com.payment.demo.dto;


import com.payment.demo.entity.PaymentStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CallbackrequestDto {

    @NotNull(message = "Payment ID is required")
    private Long paymentId;

    @NotNull(message = "Status is required")
    private PaymentStatus status;
}
