package com.swiggy.app.Email;

public class EmailRequest {
	String to;
	String body;
	String sub;
	String attachment;

	public EmailRequest(String to, String body, String sub) {
		this.to = to;
		this.body = body;
		this.sub = sub;
	}
	
	public EmailRequest(String to, String body, String sub,String attachment) {
		this.to = to;
		this.body = body;
		this.sub = sub;
		this.attachment=attachment;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	
	
}
