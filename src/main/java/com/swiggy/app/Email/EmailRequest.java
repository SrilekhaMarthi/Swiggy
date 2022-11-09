package com.swiggy.app.Email;

public class EmailRequest {
	String to;
	String body;
	String sub;

	public EmailRequest(String to, String body, String sub) {
		this.to = to;
		this.body = body;
		this.sub = sub;
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
}
