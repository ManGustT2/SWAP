package com.example.swap.data.api.model.response;

import com.example.swap.data.api.model.People;

import java.util.List;

/**
 * Created by Администратор on 01.02.2017.
 */
public class PeopleResponse {
    private List<People> results;

    public List<People> getResults(){
        return results;
    }

    public void setResults(List<People> results){
        this.results = results;
    }
}
