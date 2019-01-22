package com.hszl.erp.utils;


import com.hszl.erp.app.App;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Constant {

    public static Retrofit retrofit=new Retrofit.Builder()
            .baseUrl(URL.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(App.instance.getDefualtClient())
            .build();

    class URL
    {
        public static final String BASE_URL="http://10.0.3.16:8089/MobileApi/";
    }
}
