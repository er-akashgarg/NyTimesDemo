package com.example.akashgarg.nytimessample.retrofit;

import com.example.akashgarg.nytimessample.BuildConfig;
import com.example.akashgarg.nytimessample.common.AppConstant;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    public static ApiCalls getApi() {
        return getClient(AppConstant.BASE_URL).create(ApiCalls.class);
    }

    private static Retrofit getClient(String s) {
        Gson gson = new GsonBuilder().serializeNulls()
                .setLenient()
                .create();
        return new Retrofit.Builder()
                .baseUrl(s)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(getOkHttp())
                .build();
    }

    private static OkHttpClient getOkHttp() {
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
        okHttpBuilder.readTimeout(60, TimeUnit.SECONDS);
        okHttpBuilder.writeTimeout(60, TimeUnit.SECONDS);

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpBuilder.addNetworkInterceptor(loggingInterceptor);
        }

        return okHttpBuilder.build();
    }

}
