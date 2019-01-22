package com.hszl.erp.utils;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;


public class MyHttpLoggingIntercepter implements Interceptor {


    String tag;

    public MyHttpLoggingIntercepter(String tag) {
        this.tag = tag;
    }

    @Override
    public Response intercept(Chain chain){
        Request request = chain.request();
        //打印请求信息
        logRequestInfo(request,chain.connection());
        //记录请求开始时间
        long startTime = System.nanoTime();
        Response response=null;
        try {
            response = chain.proceed(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //记录请求开始到响应结束的时间差
        long duration = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);
//        Log.e(tag, "耗时时间" + duration);
         Response newresponse=logResponseInfo(response,duration);
//        try {
//            Log.e(tag,newresponse.body().string());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return newresponse;
    }

    /**
     * 打印响应信息
     * @param response 网络请求返回的响应对象
     * @param duration 请求开始到响应结束的时间差
     */
    private Response logResponseInfo(Response response,long duration) {
//        Response.Builder builder=response.newBuilder();
//        Response clone=builder.build();
        ResponseBody responseBody = response.body();
        try {
            String ResponseMessage="<--"+response.code()+" "+response.message()+" "+response.request().url()+" ("+duration+"ms)";
            Log.e(tag,ResponseMessage);
            Headers headers
                    = response.headers();
            for (int i = 0; i < headers.size(); i++) {
                Log.e(tag, headers.name(i) + ":"+headers.value(i));
            }
            if (responseBody != null) {
                Log.e(tag, "contentLength:" + responseBody.contentLength());
                Log.e(tag, "contentType:" + responseBody.contentType().toString());
            }
            //打印响应体
//            BufferedSource bufferedSource=Okio.buffer(Okio.source(responseBody.byteStream()));
//            String str=bufferedSource.readUtf8();
            String str=response.body().string();
            Log.e(tag,"response"+str);
            MediaType mediaType=responseBody.contentType();
            ResponseBody newBody=ResponseBody.create(mediaType,str);
            Response clone=response.newBuilder().body(newBody).build();
            return clone;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            Log.e(tag,"<-- END HTTP");
        }
        return response;
    }

    /**
     * 打印请求信息
     * @param request 请求的请求体对象
     * @param connection 请求的连接对象
     */
    private void logRequestInfo(Request request, Connection connection) {
        RequestBody requestBody = request.body();
        Protocol protocol = connection != null ? connection.protocol() : Protocol.HTTP_1_1;
        try {
            if (requestBody != null) {
                String RequestMessage="-->"+request.method()+" "+request.url()+" "+protocol;
                Log.e(tag,RequestMessage);
                Log.e(tag, "contentLength:" + requestBody.contentLength());
                Log.e(tag, "contentType:" + requestBody.contentType().toString());
                Log.e(tag,"cache-control:"+request.cacheControl());
            }
            Headers headers = request.headers();
            for (int i = 0; i < headers.size(); i++) {
                String name = headers.name(i);
                Log.e(tag, name +":"+headers.value(i));
            }
            //打印请求体
            Buffer buffer=new Buffer();
            Request clone=request.newBuilder().build();
            RequestBody body=clone.body();
            body.writeTo(buffer);
            String str=buffer.readUtf8();
            Log.e(tag,"requestBody"+str);
        } catch (IOException ex) {
            ex.printStackTrace();
        }finally {
            Log.e(tag,"--> END  "+request.method());
        }
    }
}
