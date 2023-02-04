package com.wbd.dorayakisupplier.httpclient.response;

import com.google.gson.annotations.SerializedName;

public class IngredientsItem{

	@SerializedName("quantity")
	private int quantity;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	public int getQuantity(){
		return quantity;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}
}