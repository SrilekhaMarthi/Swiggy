package com.swiggy.app.Master;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;
import com.swiggy.app.GResponse.GResponse;

@RestController
@RequestMapping("/api/master")
public class MasterController {

	@Autowired
	private MasterService masterService;
	@Autowired
	private GResponse gResponse;


	@GetMapping("/processOrder/{id}")
	public Master processOrder(@PathVariable Long id) throws IOException, MessagingException {
		return masterService.processOrder(id);
	}

	@GetMapping("/all")
	public GResponse getAllMasters() {
		gResponse.setData(masterService.getAllMasters());
		return gResponse;
	}
	
	@GetMapping("/{id}")
	public GResponse getMasterById(@PathVariable Long id) {
		gResponse.setData(masterService.getMasterById(id));
		return gResponse;
	}

	@DeleteMapping("/deleteOrder/{id}")
	public GResponse deleteMasterById(@PathVariable Long id) {
		gResponse.setData(masterService.deleteMasterById(id));
		return gResponse;
	}
	
	@GetMapping("/pdf/orders")
	public void generatePdf(HttpServletResponse response) throws DocumentException, IOException {
		masterService.generatePdf(response);
	}
	
	@GetMapping("/orderInfo/{id}")
	public void generateOrderInfo(HttpServletResponse response,@PathVariable Long id) throws DocumentException,IOException{
		masterService.generateOrderInfo(response, id);
	}
	
	@GetMapping("/orderInfoLink/{id}")
	public String generateOrderInfoLink(HttpServletResponse response,@PathVariable Long id) throws DocumentException,IOException{
		System.out.println(masterService.generateOrderInfoLink(response,id));
		return masterService.generateOrderInfoLink(response, id);
	}
	
	

}
