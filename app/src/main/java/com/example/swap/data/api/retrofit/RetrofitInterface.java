package com.example.swap.data.api.retrofit;

import com.example.swap.data.api.model.Film;
import com.example.swap.data.api.model.People;
import com.example.swap.data.api.model.response.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Администратор on 14.12.2016.
 */
public interface RetrofitInterface {

    @GET("films/")
    Call<ResponseModel<Film>> getFilms();

    @GET("people/")
    Call<ResponseModel<People>> getPeople();

}
