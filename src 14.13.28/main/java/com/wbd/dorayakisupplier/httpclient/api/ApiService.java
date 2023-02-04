package com.wbd.dorayakisupplier.httpclient.api;

import com.wbd.dorayakisupplier.httpclient.request.RequestCreation;
import com.wbd.dorayakisupplier.httpclient.response.HTTPResponse;
import com.wbd.dorayakisupplier.httpclient.response.RecipeListItem;
import com.wbd.dorayakisupplier.httpclient.response.RequestListItem;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

public interface ApiService {
    @GET("recipes/")
    Call<HTTPResponse<List<RecipeListItem>>> getRecipeList();

    @GET("requests/")
    Call<HTTPResponse<List<RequestListItem>>> getRequestList();

    @POST("requests/create")
    Call<HTTPResponse<RequestListItem>> createRequest(@Body RequestCreation request);

}
