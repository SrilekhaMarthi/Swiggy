package com.swiggy.app.Utility;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

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

@Service
public class PdfGenerator {

	public void setResponseHeader(HttpServletResponse response, String contentType, String extension, String prefix)
			throws IOException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		String timeStamp = dateFormat.format(new Date());
		String fileName = prefix + timeStamp + extension;
		response.setContentType(contentType);

		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=order.pdf";
		response.setHeader(headerKey, headerValue);
	}

	public void generate(HttpServletResponse response, List<Master> orders) throws DocumentException, IOException {
		setResponseHeader(response, "application/pdf", ".pdf", "Orders");

		Document document = new Document(PageSize.A2);
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();

		Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTitle.setSize(18);

		Paragraph paragraph = new Paragraph("List Of Orders", fontTitle);
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(paragraph);

		PdfPTable table = new PdfPTable(14);
		table.setWidthPercentage(100f);
		table.setWidths(new int[] { 1, 3, 3, 3, 3, 4, 6, 2, 3, 3, 3, 3, 3, 3 });
		table.setSpacingBefore(8);

		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(CMYKColor.darkGray);
		cell.setPadding(5);

		Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		font.setColor(CMYKColor.WHITE);

		cell.setPhrase(new Phrase("OID", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("RName", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("RLocation", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("UName", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("UAddress", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("UMail", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Items", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Total", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("EstDelTime", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("DName", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Dphone", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("PayMode", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("PayStatus", font));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Order Status", font));
		table.addCell(cell);

		for (Master order : orders) {
			table.addCell(String.valueOf(order.getId()));
			table.addCell(order.getRestuarantName());
			table.addCell(order.getRestuarantLocation());
			table.addCell(order.getUserName());
			table.addCell(order.getUserAddress());
			table.addCell(order.getUserMail());
			table.addCell(String.valueOf(order.getItemNames()));
			table.addCell(String.valueOf(order.getTotal()));
			table.addCell(order.getEstDelTime());
			table.addCell(order.getPersonName());
			table.addCell(order.getPersonPhone());
			table.addCell(order.getPaymentMode());
			table.addCell(order.getPaymentStatus());
			table.addCell(order.getOrderStatus());
		}
		document.add(table);
		document.close();
	}

	public void generateAs(HttpServletResponse response, Master order) throws DocumentException, IOException {
		setResponseHeader(response, "application/pdf", ".pdf", "Order");

		Document document = new Document(PageSize.A5);
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();

		Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTitle.setSize(15);

		Paragraph paragraph = new Paragraph("Order Info", fontTitle);
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(paragraph);

		document.add(new Paragraph("\nOrdered From:" + "\n" + "Name : " + order.getRestuarantName() + "\n" + "Address : "
				+ order.getRestuarantLocation() + "\n\n" + "Delivery To:" + "\n" + "Name : " + order.getUserName()
				+ "\n" + "Address : " + order.getUserAddress()));
		document.add(new Paragraph("\nItems : "  + order.getItemNames()));
		document.add(
				new Paragraph("Total : " + order.getTotal()+" rupees"));
		document.add(new Paragraph("\nDelivery Man Details:"+"\n"+
		"Name : "+order.getPersonName()+
								"\n" + "Contact : "+order.getPersonPhone()+
								"\n"+"Estimated Delivery Time : "+order.getEstDelTime()));
		
		Paragraph foot = new Paragraph("\n\nThank You for ordering!Wish to serve you again.");
		foot.setAlignment(foot.ALIGN_CENTER);
		document.add(foot);
		
		
		document.close();
	}
}
