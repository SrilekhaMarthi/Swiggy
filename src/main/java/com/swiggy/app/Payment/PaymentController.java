package com.swiggy.app.Payment;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swiggy.app.GResponse.GResponse;

@RestController
@RequestMapping("/api/Payment")
public class PaymentController {
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private GResponse gResponse;
	
	@GetMapping("/all")
	public GResponse getAll() {
		gResponse.setData(paymentService.getAllPayments());
		return gResponse;
	}
	
	@GetMapping("/{id}")
	public GResponse getById(@PathVariable Long id) {
		gResponse.setData(paymentService.getPaymentById(id));
		return gResponse;
	}
	
	@PostMapping
	public GResponse insertPayment(@Valid @RequestBody Payment payment) {
		gResponse.setData(paymentService.insertPayment(payment));
		return gResponse;
	}
	
	
	
	
}
