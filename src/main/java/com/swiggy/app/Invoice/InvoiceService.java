package com.swiggy.app.Invoice;

import java.util.List;

public interface InvoiceService {
	
	List<Invoice> getAll();
	
	Invoice getInvoiceById(Long id);
	
	String deleteInvoiceById(Long id);
	
	Invoice addInvoice(Invoice invoice);
	
	
}
