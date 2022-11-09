package com.swiggy.app.Utility;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.swiggy.app.Master.Master;

public class PdfGenerator {
	
	private List<Master> masterList;
	
	public void generate(HttpServletResponse response,List<Master> orders) throws DocumentException,IOException{
		Document document = new Document(PageSize.A4);
		
		PdfWriter.getInstance(document,response.getOutputStream());
		
		document.open();
		
		Font fontTitle =  FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTitle.setSize(20);
		
		Paragraph paragraph = new Paragraph("List Of Orders", fontTitle);

		paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(paragraph);

		PdfPTable table = new PdfPTable(21);
		
		table.setWidthPercentage(300f);
		table.setWidths(new int[] { 3, 3, 3 });
		table.setSpacingBefore(5);

		PdfPCell cell = new PdfPCell();

		cell.setBackgroundColor(CMYKColor.MAGENTA);
		cell.setPadding(5);
		
		Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		font.setColor(CMYKColor.WHITE);

		cell.setPhrase(new Phrase("ID", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Restaurant ID", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Restaurant Name", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Restaurant Location", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("User ID", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("User Name", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("User Address", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("User Mail", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("User Phone", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Items", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Cart ID", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Cart SubTotal", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Gst", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Delivery Charges", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Estimated Delivery Time", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Person ID", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Person Name", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Person Phone", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Payment ID", font));
		table.addCell(cell);
		table.addCell(cell);
		cell.setPhrase(new Phrase("Payment Mode", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Payment Status", font));
		table.addCell(cell);
		table.addCell(cell);
		cell.setPhrase(new Phrase("Transaction ID", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Invoice Link", font));
		table.addCell(cell);
		table.addCell(cell);
		cell.setPhrase(new Phrase("Order Status", font));
		table.addCell(cell);
		
		
		for (Master order : masterList) {
			table.addCell(String.valueOf(order.getId()));
			table.addCell(String.valueOf(order.getRestuarantId()));
			table.addCell(order.getRestuarantName());
			table.addCell(order.getRestuarantLocation());
			table.addCell(String.valueOf(order.getUserId()));
			table.addCell(order.getUserName());
			table.addCell(order.getUserAddress());
			table.addCell(order.getUserMail());
			table.addCell(order.getUserPhone());
			table.addCell(String.valueOf(order.getItems()));
			table.addCell(String.valueOf(order.getCartId()));
			table.addCell(String.valueOf(order.getCartSubTotal()));
			table.addCell(String.valueOf(order.getGst()));
			table.addCell(String.valueOf(order.getDeliveryCharges()));
			table.addCell(order.getEstDelTime());
			table.addCell(order.getPersonName());
			table.addCell(order.getPersonPhone());
			table.addCell(String.valueOf(order.getPaymentId()));
			table.addCell(order.getPaymentMode());
			table.addCell(order.getPaymentStatus());
			table.addCell(order.getTransactionId());
			table.addCell(order.getInvoiceLink());
			table.addCell(order.getOrderStatus());
		}
		document.add(table);

		document.close();
	}
}
