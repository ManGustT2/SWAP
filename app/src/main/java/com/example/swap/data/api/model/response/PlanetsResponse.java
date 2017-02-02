package com.example.swap.data.api.model.response;

import com.example.swap.data.api.model.Planets;

import java.util.List;

/**
 * Created by Администратор on 01.02.2017.
 */
public class PlanetsResponse {
    private List<Planets> results;

    public List<Planets> getResults(){
        return results;
    }

    public void setResults(List<Planets> results){
        this.results = results;
    }
}
