package com.swiggy.app.Master;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.lowagie.text.DocumentException;
import com.swiggy.app.Customer.Customer;
import com.swiggy.app.Customer.CustomerRepository;
import com.swiggy.app.DPerson.DPerson;
import com.swiggy.app.DPerson.DPersonRepository;
import com.swiggy.app.Email.EmailSenderService;
import com.swiggy.app.Invoice.Invoice;
import com.swiggy.app.Invoice.InvoiceRepository;
import com.swiggy.app.Payment.Payment;
import com.swiggy.app.Payment.PaymentRepository;
import com.swiggy.app.Repository.CartRepository;
import com.swiggy.app.Repository.RestaurantRepository;
import com.swiggy.app.Utility.PdfGenerator;
import com.swiggy.app.model.Cart;
import com.swiggy.app.model.Restaurant;

@Service
public class MasterServiceImpl implements MasterService {
	@Autowired
	HttpServletResponse response;
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
	private Gson gson;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private MasterRepository masterRepo;
	@Autowired
	private PdfGenerator pdfGenerator;

	private static final String orderStatus = "preparing";

	@Override
	public Master saveMaster(Master master) {
		return masterRepo.save(master);
	}

	@Override
	public List<Master> getAllMasters() {
		return masterRepo.findAll();
	}

	@Override
	public Master getMasterById(Long id) {
		return masterRepo.findById(id).get();
	}

	@Override
	public String deleteMasterById(Long id) {
		masterRepo.deleteById(id);
		return "deleted successfully";
	}

	@Override
	public Master processOrder(Long id) throws IOException, MessagingException {
		Cart cart = cartRepo.findById(id).get();

		String items = gson.toJson(cart.getItems());
		JsonNode node = objectMapper.readTree(items);

		String itemNames = cart.getItems().stream().map(item -> item.getName()).collect(Collectors.toList()).toString();

		Long userId = cart.getUserId();
		Customer user = userRepo.findById(userId).get();

		Long restaurantId = cart.getRestaurantId();
		Restaurant restaurant = restaurantRepo.findById(restaurantId).get();

		Long dpersonId = 4L;
		DPerson dPerson = dPersonRepo.findById(dpersonId).get();

		Long paymentId = 1L;
		Payment payment = paymentRepo.findById(paymentId).get();

		Long invoiceId = 1L;
		Invoice invoice = invoiceRepo.findById(invoiceId).get();

		Master mstr = new Master(restaurantId, restaurant.getName(), restaurant.getAddress(), userId, user.getName(),
				user.getAddress(), user.getMail(), user.getPhone(), node, itemNames, id, invoice.getTotal(),
				dPerson.getestDelTime(), dpersonId, dPerson.getName(), dPerson.getPhoneNumber(), paymentId,
				payment.getMode(), payment.getStatus(), payment.getTransactionId(), invoice.getLink(), orderStatus);
		masterRepo.save(mstr);

		cartRepo.deleteById(id);

		emailService.sendMailWithAttachment("sendthistoea@gmail.com",
				"Your order is received and we will deliver it very soon.Thank you and wish you a happy day!",
				"orderInfo", generateOrderInfoLink(response, id));

		return mstr;

	}

	@Override
	public void generatePdf(HttpServletResponse response) throws DocumentException, IOException {
		List<Master> orders = getAllMasters();
		pdfGenerator.generate(response, orders);
	}

	@Override
	public void generateOrderInfo(HttpServletResponse response, Long id) throws DocumentException, IOException {
		Master order = getMasterById(id);
		pdfGenerator.generateAs(response, order);
	}

	@Override
	public String generateOrderInfoLink(HttpServletResponse response, Long id) throws DocumentException, IOException {
		Master order = masterRepo.findByCartId(id);
		System.out.println(order);
		pdfGenerator.generateAs(response, order);
		String link = "/home/akileshcmt/Downloads/order.pdf";
		return link;
	}

}
