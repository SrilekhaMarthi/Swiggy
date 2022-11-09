package com.swiggy.app.Payment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService{
	@Autowired
	private PaymentRepository paymentRepo;

	@Override
	public Payment getPaymentById(Long id) {
		return paymentRepo.findById(id).get();
	}

	@Override
	public List<Payment> getAllPayments() {
		return paymentRepo.findAll();
	}

	@Override
	public Payment insertPayment(Payment payment) {
		return paymentRepo.save(payment);
	}

	
	
	
	
	
	
}
