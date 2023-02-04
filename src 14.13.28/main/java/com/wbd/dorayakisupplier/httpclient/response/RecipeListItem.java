package com.wbd.dorayakisupplier.httpclient.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RecipeListItem {

	@SerializedName("createdAt")
	private String createdAt;

	@SerializedName("deletedAt")
	private Object deletedAt;

	@SerializedName("name")
	private String name;

	@SerializedName("ingredients")
	private List<IngredientsItem> ingredients;

	@SerializedName("id")
	private int id;

	@SerializedName("updatedAt")
	private String updatedAt;

	public String getCreatedAt(){
		return createdAt;
	}

	public Object getDeletedAt(){
		return deletedAt;
	}

	public String getName(){
		return name;
	}

	public List<IngredientsItem> getIngredients(){
		return ingredients;
	}

	public int getId(){
		return id;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}
}