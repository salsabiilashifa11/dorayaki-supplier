package com.wbd.dorayakisupplier.httpclient.api;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class ApiConfig {

    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjoxLCJlbWFpbCI6ImFuZHJlcy5zaW5hYnV0YXJAZ21haWwuY29tIiwibmFtZSI6IkFuZHJlcyJ9LCJpYXQiOjE2Mzc4OTk1ODV9.Ynuihg59i2Kfw989GxtFpKz1XyFFeNe4VVtI_VfGzxM";

    public static ApiService getApiService() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.HEADERS))
                .addInterceptor(new Interceptor() {
                    @NotNull
                    @Override
                    public Response intercept(@NotNull Chain chain) throws IOException {
                        Request original = chain.request();
                        Request newRequest = original.newBuilder()
                                .addHeader("Authorization", "Bearer " + TOKEN)
                                .build();
                        return chain.proceed(newRequest);
                    }
                }).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit.create(ApiService.class);
    }
}
