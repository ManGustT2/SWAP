package com.example.swap.data.api.retrofit;
import com.example.swap.data.api.model.FilmsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Администратор on 14.12.2016.
 */
public interface RetrofitInterface {

    @GET("films/")
    Call<FilmsResponse> getFilms();
}
