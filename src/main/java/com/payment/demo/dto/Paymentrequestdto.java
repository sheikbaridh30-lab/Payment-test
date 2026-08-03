package com.payment.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Paymentrequestdto {

 @NotBlank(message = "Order ID is required")
 private String orderId;

 @NotNull(message = "Amount is required")
 @Positive(message = "Amount must be greater than zero")
 private BigDecimal amount;

 @NotBlank(message = "Currency is required")
 private String currency;

 private boolean simulateFailure;
}
