package com.swiggy.app.Master;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.DocumentException;

public interface MasterService {
	
	Master saveMaster(Master master);
	
	List<Master> getAllMasters();
	
	Master getMasterById(Long id);
	
	String deleteMasterById(Long id);
	
	Master processOrder(Long id) throws IOException, MessagingException;
	
	void generatePdf(HttpServletResponse response) throws DocumentException, IOException;
	
	void generateOrderInfo(HttpServletResponse response,Long id) 
			throws DocumentException,IOException;

	String generateOrderInfoLink(HttpServletResponse response, Long id) throws DocumentException, IOException;

	
	
}
