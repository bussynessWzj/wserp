package com.hszl.erp.http;


import com.hszl.erp.entity.User;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface HttpInterface {
    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST("UserLogin")
    Call<User> login(@Body RequestBody route);
}
