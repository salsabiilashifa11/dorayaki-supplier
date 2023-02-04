package com.wbd.dorayakisupplier.httpclient;

import com.wbd.dorayakisupplier.model.Recipe;
import com.wbd.dorayakisupplier.model.RecipeList;
import com.wbd.dorayakisupplier.model.Request;
import com.wbd.dorayakisupplier.model.RequestList;
import com.wbd.dorayakisupplier.httpclient.api.ApiConfig;
import com.wbd.dorayakisupplier.httpclient.api.ApiService;
import com.wbd.dorayakisupplier.httpclient.request.RequestCreation;
import com.wbd.dorayakisupplier.httpclient.response.HTTPResponse;
import com.wbd.dorayakisupplier.httpclient.response.RecipeListItem;
import com.wbd.dorayakisupplier.httpclient.response.RequestListItem;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class HttpClient {
    private final ApiService apiService = ApiConfig.getApiService();

    public RecipeList getAllRecipes() {
        RecipeList recipeList = new RecipeList();
        try {
            Call<HTTPResponse<List<RecipeListItem>>> responseCall = apiService.getRecipeList();
            Response<HTTPResponse<List<RecipeListItem>>> response = responseCall.execute();
            response.body().getData().forEach(item -> recipeList.getRecipes().add(Recipe.valueOf(item)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return recipeList;
    }

    public RequestList getAllRequests() {
        RequestList requestList = new RequestList();

        try {
            Call<HTTPResponse<List<RequestListItem>>> responseCall = apiService.getRequestList();
            Response<HTTPResponse<List<RequestListItem>>> response = responseCall.execute();
            response.body().getData().forEach(item -> requestList.getRequests().add(Request.valueOf(item)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return requestList;
    }

    public Request createNewRequest(Integer recipeId, Integer quantity) {
        RequestCreation request = new RequestCreation(recipeId, quantity);

        try {
            Call<HTTPResponse<RequestListItem>> responseCall = apiService.createRequest(request);
            Response<HTTPResponse<RequestListItem>> response = responseCall.execute();
            if (response.isSuccessful()) {
                if (response.body() != null) {
                    return Request.valueOf(response.body().getData());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
