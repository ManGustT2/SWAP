package com.example.swap.data.api.retrofit;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by Администратор on 14.12.2016.
 */
public class RestClient {

    private static final OkHttpClient CLIENT = new OkHttpClient.Builder()
            .build();

    private static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .client(CLIENT)
                .build();
    }

    public static RetrofitInterface getRetrofitAdapter() {
        return getRetrofit().create(RetrofitInterface.class);
    }


    }