package com.swiggy.app.GResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class GResponse {
	private Integer status;
	private Object data;
	private Object error;
	
	public GResponse() {
		
	}
	
	public GResponse(Integer status,Object data,Object error) {
		this.status = HttpStatus.OK.value();
		this.data = data;
		this.error = error;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Object getError() {
		return error;
	}
	public void setError(Object error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "GResponse [status=" + status + ", data=" + data + ", error=" + error + "]";
	}
	
	
	
}
