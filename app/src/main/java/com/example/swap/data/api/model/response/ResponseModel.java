package com.example.swap.data.api.model.response;

import java.util.List;

/**
 * Created by Администратор on 14.12.2016.
 */
public class ResponseModel<T> {
    private List<T> results;

    public List<T> getResults(){
        return results;
    }

    public void setResults(List<T> results){
        this.results = results;
    }
}
