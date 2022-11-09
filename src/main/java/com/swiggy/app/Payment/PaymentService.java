package com.swiggy.app.Payment;

import java.util.List;

public interface PaymentService {
	
	Payment getPaymentById(Long id);
	
	List<Payment> getAllPayments();
	
	Payment insertPayment(Payment payment);
	
	
	
	
}
