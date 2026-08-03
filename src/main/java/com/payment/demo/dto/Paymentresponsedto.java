package com.payment.demo.dto;

import com.payment.demo.entity.PaymentStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Paymentresponsedto {
    private Long paymentId;

    private PaymentStatus status;

    private String message;
}
