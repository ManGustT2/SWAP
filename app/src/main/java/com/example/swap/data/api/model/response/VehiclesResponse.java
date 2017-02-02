package com.example.swap.data.api.model.response;

import com.example.swap.data.api.model.Starships;

import java.util.List;

/**
 * Created by Администратор on 01.02.2017.
 */
public class VehiclesResponse {
    private List<Starships> results;

    public List<Starships> getResults(){
        return results;
    }

    public void setResults(List<Starships> results){
        this.results = results;
    }
}
