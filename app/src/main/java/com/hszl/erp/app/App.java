package com.hszl.erp.app;

import android.app.Application;

import com.hszl.erp.utils.MyHttpLoggingIntercepter;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class App extends Application {

    public static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
    }

    /**
     * 获取默认okhttpclient对象并设置对象的应用程序拦截器（网络请求拦截打印相关信息信息）
     * @return
     */
    public OkHttpClient getDefualtClient() {
        OkHttpClient.Builder builder=new OkHttpClient.Builder();
        builder.addInterceptor(new MyHttpLoggingIntercepter("http"));     //设置打印拦截器tag
        builder.writeTimeout(6000,TimeUnit.MILLISECONDS);
        builder.readTimeout(6000,TimeUnit.MILLISECONDS);
        builder.connectTimeout(6000,TimeUnit.MILLISECONDS);
        OkHttpClient client=builder.build();
        return client;
    }
}
