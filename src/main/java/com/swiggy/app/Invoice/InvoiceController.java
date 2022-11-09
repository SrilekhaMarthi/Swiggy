package com.swiggy.app.Invoice;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swiggy.app.GResponse.GResponse;

@RestController
@RequestMapping("/api/Invoice")
public class InvoiceController {
	@Autowired
	private InvoiceService invoiceService;
	@Autowired
	private GResponse gResponse;

	@GetMapping("/all")
	public GResponse getAllInvoices() {
		gResponse.setData(invoiceService.getAll());
		return gResponse;
	}

	@GetMapping("/{id}")
	public GResponse getInvoiceById(@PathVariable Long id) {
		gResponse.setData(invoiceService.getInvoiceById(id));
		return gResponse;
	}

	@PostMapping
	public GResponse addInvoice(@Valid @RequestBody Invoice invoice) {
		gResponse.setData(invoiceService.addInvoice(invoice));
		return gResponse;
	}

	@DeleteMapping("delete/{id}")
	public GResponse deleteInvoice(@PathVariable Long id) {
		gResponse.setData(invoiceService.deleteInvoiceById(id));
		return gResponse;
	}

}
