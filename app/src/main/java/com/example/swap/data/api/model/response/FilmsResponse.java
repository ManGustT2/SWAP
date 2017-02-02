package com.example.swap.data.api.model.response;

import com.example.swap.data.api.model.Film;

import java.util.List;

/**
 * Created by Администратор on 14.12.2016.
 */
public class FilmsResponse {
    private List<Film> results;

    public List<Film> getResults(){
        return results;
    }

    public void setResults(List<Film> results){
        this.results = results;
    }
}
