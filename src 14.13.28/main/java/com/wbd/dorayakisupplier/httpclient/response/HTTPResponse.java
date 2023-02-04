package com.wbd.dorayakisupplier.httpclient.response;

import com.google.gson.annotations.SerializedName;

public class HTTPResponse<E>{

	@SerializedName("data")
	private E data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public E getData(){
		return data;
	}

	public boolean isSuccess(){
		return success;
	}

	public String getMessage(){
		return message;
	}
}