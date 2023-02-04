package com.wbd.dorayakisupplier.httpclient.request;

import com.google.gson.annotations.SerializedName;

public class RequestCreation {

    @SerializedName("recipeId")
    private Integer recipeId;

    @SerializedName("quantity")
    private Integer quantity;

    public RequestCreation(Integer recipeId, Integer quantity) {
        this.recipeId = recipeId;
        this.quantity = quantity;
    }

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}