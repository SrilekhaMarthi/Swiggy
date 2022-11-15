package com.swiggy.app.Invoice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl implements InvoiceService{
	
	@Autowired
	InvoiceRepository invoiceRepo;

	@Override
	public List<Invoice> getAll() {
		return invoiceRepo.findAll();
	}

	@Override
	public Invoice getInvoiceById(Long id) {
		return invoiceRepo.findById(id).get();
	}

	@Override
	public String deleteInvoiceById(Long id) {
		invoiceRepo.deleteById(id);
		return "deleted Successfully!";
	}

	@Override
	public Invoice addInvoice(Invoice invoice) {
		double total = 0;
		double cartSubTotal = invoice.getCartSubTotal();
		double gst = invoice.getGst();
		double dCharges = invoice.getDeliveryCharges();
		total = cartSubTotal+gst+dCharges;
		invoice.setTotal(total);
		return invoiceRepo.save(invoice);
	}

	

}
