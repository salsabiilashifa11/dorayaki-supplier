package com.wbd.dorayakisupplier.httpclient.response;

import com.google.gson.annotations.SerializedName;

public class RequestListItem {

	@SerializedName("createdAt")
	private String createdAt;

	@SerializedName("quantity")
	private int quantity;

	@SerializedName("createdBy")
	private String createdBy;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("status")
	private String status;

	@SerializedName("updatedAt")
	private String updatedAt;

	public String getCreatedAt(){
		return createdAt;
	}

	public int getQuantity(){
		return quantity;
	}

	public String getCreatedBy(){
		return createdBy;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	public String getStatus(){
		return status;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}
}