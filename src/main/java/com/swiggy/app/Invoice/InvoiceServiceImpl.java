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
		return invoiceRepo.save(invoice);
	}

	

}
