package com.payment.demo.reponsitory;

import com.payment.demo.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface paymentrepository extends JpaRepository<Payment, Long> {

}
