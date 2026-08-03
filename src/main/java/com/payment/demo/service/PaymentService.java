package com.payment.demo.service;

import com.payment.demo.dto.Paymentresponsedto;
import com.payment.demo.dto.Paymentrequestdto;
import com.payment.demo.entity.Payment;
import com.payment.demo.entity.PaymentStatus;
import com.payment.demo.exception.PaymentNotFoundException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.payment.demo.reponsitory.paymentrepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final paymentrepository paymentrepository;

    public Paymentresponsedto createPayment(Paymentrequestdto request) {

        Payment payment = Payment.builder()
                .orderId(request.getOrderId())
                .amount(request.getAmount())
                .currency(request.getCurrency())
                .status(PaymentStatus.PENDING)
                .createdAt(LocalDateTime.now())
                .build();

        payment = paymentrepository.save(payment);

        if (request.isSimulateFailure()) {
            payment.setStatus(PaymentStatus.FAILED);
            paymentrepository.save(payment);

            return Paymentresponsedto.builder()
                    .paymentId(payment.getId())
                    .status(PaymentStatus.FAILED)
                    .message("Mock gateway payment failed")
                    .build();
        }

        payment.setStatus(PaymentStatus.SUCCESS);
        paymentrepository.save(payment);

        return Paymentresponsedto.builder()
                .paymentId(payment.getId())
                .status(PaymentStatus.SUCCESS)
                .message("Payment processed successfully")
                .build();
    }

    public Payment getPayment(Long id) {
        return paymentrepository.findById(id)
                .orElseThrow(() -> new PaymentNotFoundException("Payment not found with id: " + id));
    }

    public Payment updateStatus(Long paymentId, PaymentStatus status) {

        Payment payment = getPayment(paymentId);
        payment.setStatus(status);

        return paymentrepository.save(payment);
    }
}