package com.swiggy.app.Master;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.lowagie.text.DocumentException;
import com.swiggy.app.DPerson.DPerson;
import com.swiggy.app.DPerson.DPersonRepository;
import com.swiggy.app.Email.EmailSenderService;
import com.swiggy.app.GResponse.GResponse;
import com.swiggy.app.Invoice.Invoice;
import com.swiggy.app.Invoice.InvoiceRepository;
import com.swiggy.app.Payment.Payment;
import com.swiggy.app.Payment.PaymentRepository;
import com.swiggy.app.Repository.CartRepository;
import com.swiggy.app.Repository.CustomerRepository;
import com.swiggy.app.Repository.RestaurantRepository;
import com.swiggy.app.Service.CartService;
import com.swiggy.app.Utility.PdfGenerator;
import com.swiggy.app.model.Cart;
import com.swiggy.app.model.Customer;
import com.swiggy.app.model.Restaurant;

@RestController
@RequestMapping("/api/master")
public class MasterController {
	
	@Autowired
	private MasterService masterService;
	@Autowired
	private CustomerRepository userRepo;
	@Autowired
	private RestaurantRepository restaurantRepo;

	@Autowired
	private DPersonRepository dPersonRepo;
	@Autowired
	private PaymentRepository paymentRepo;
	@Autowired
	private EmailSenderService emailService;
	@Autowired
	private CartRepository cartRepo;
	@Autowired
	private InvoiceRepository invoiceRepo;
	@Autowired
	private CartService cartService;
	@Autowired 
	private GResponse gResponse;
	
	@GetMapping("/getMaster/{id}")
	public Master getData(@PathVariable Long id) throws IOException {
		Cart cart=cartRepo.findById(id).get();
		System.out.println(cart);
		
		String items = new Gson().toJson(cart.getItems());
		ObjectMapper map = new ObjectMapper();
		JsonNode node = map.readTree(items);
		
		Long userId = cart.getUserId();
		Customer user = userRepo.findById(userId).get();
		String userName = user.getName();
		String userAddress = user.getAddress();
		String userMail = user.getMail();
		String userPhone = user.getPhone();
		
		Long restaurantId = cart.getRestaurantId();
		Restaurant restaurant = restaurantRepo.findById(restaurantId).get();
		String restaurantName = restaurant.getName();
		String restaurantLocation =  restaurant.getAddress();
		
		Long dpersonId = 4L;
		DPerson dPerson = dPersonRepo.findById(dpersonId).get();
		String dPersonName = dPerson.getName();
		String dPersonPhone = dPerson.getPhoneNumber();
		String estDelTime = dPerson.getestDelTime();
		
		Long paymentId = 1L;
		Payment payment = paymentRepo.findById(paymentId).get();
		String paymentMode = payment.getMode();
		String paymentStatus = payment.getStatus();
	    String transactionId = payment.getTransactionId();
	    
	    Long invoiceId=2L;
	    Invoice invoice = invoiceRepo.findById(invoiceId).get();
	    double gst = invoice.getGst();
	    double cartSubTotal = cartService.getSubTotal(userId, restaurantId);
	    double deliveryCharges = invoice.getDeliveryCharges();
	    String invoiceLink = invoice.getLink();
	    
	    String orderStatus = "Preparing";
	    
	    Master mstr = new Master(restaurantId,restaurantName,restaurantLocation,userId,
				   userName, userAddress,userMail,userPhone, node,4L,cartSubTotal,gst,deliveryCharges,estDelTime,
					4L,dPersonName,dPersonPhone,paymentId,paymentMode, paymentStatus,
					transactionId,invoiceLink,orderStatus);
	    masterService.saveMaster(mstr);
	    
	    cartRepo.deleteById(id);
	    
	    emailService.sendSimpleEmail("srilekhams817@gmail.com","Your order is received and we will deliver it very soon.Thank you and wish you a happy day!","Order");
		
	   return mstr;
	  
	}
	
	@GetMapping("/all")
	public GResponse getAllMasters() {
		gResponse.setData(masterService.getAllMasters());
		return gResponse;
	}
	
	 @GetMapping("/pdf/orders")
		public void generatePdf(HttpServletResponse response) throws DocumentException, IOException {
			
			response.setContentType("application/pdf");
			DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
			String currentDateTime = dateFormat.format(new Date());
			String headerkey = "Content-Disposition";
			String headervalue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
			response.setHeader(headerkey, headervalue);
			
			List<Master> orders = masterService.getAllMasters();
			System.out.println(orders);
			
			PdfGenerator generator = new PdfGenerator();
			generator.generate(response,orders);
			
		}
	
	
	
}
