package com.example.swap.data.api.model.response;

import com.example.swap.data.api.model.Species;

import java.util.List;

/**
 * Created by Администратор on 01.02.2017.
 */
public class SpeciesResponse {
    private List<Species> results;

    public List<Species> getResults(){
        return results;
    }

    public void setResults(List<Species> results){
        this.results = results;
    }
}
