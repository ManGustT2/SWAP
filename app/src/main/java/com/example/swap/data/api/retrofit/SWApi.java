package com.example.swap.data.api.retrofit;

import com.example.swap.data.api.model.response.FilmsResponse;
import com.example.swap.data.api.model.response.PeopleResponse;
import com.example.swap.data.api.model.response.PlanetsResponse;
import com.example.swap.data.api.model.response.SpeciesResponse;
import com.example.swap.data.api.model.response.StarshipsResponse;
import com.example.swap.data.api.model.response.VehiclesResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Администратор on 14.12.2016.
 */
public interface SWApi {

    @GET("films/")
    Call<FilmsResponse> getFilms();

    @GET("people/")
    Call<PeopleResponse> getPeople();

    @GET("planets/")
    Call<PlanetsResponse> getPlanets();

    @GET("species/")
    Call<SpeciesResponse> getSpecies();

    @GET("vehicles/")
    Call<VehiclesResponse> getVehicles();

    @GET("starships/")
    Call<StarshipsResponse> getStarships();

}
