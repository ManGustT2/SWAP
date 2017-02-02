package com.example.swap.data.api.retrofit;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Администратор on 14.12.2016.
 */
public class RestClient {

    private static final OkHttpClient CLIENT = new OkHttpClient.Builder()
            .build();

    private static Retrofit getRetrofit(HttpUrl url) {
//
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(CLIENT)
                .build();
    }

    public static SWApi getRetrofitAdapter(HttpUrl url, OkHttpClient client) {
//        HttpUrl url = new HttpUrl.Builder()
//                .host("swapi.co")
//                .scheme("http")
//                .addEncodedPathSegment("api")
//                .build();
        return getRetrofit(url).create(SWApi.class);
    }


}