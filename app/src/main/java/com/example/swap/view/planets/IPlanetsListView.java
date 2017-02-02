package com.example.swap.view.planets;

import com.example.swap.data.api.model.Planets;

import java.util.List;

/**
 * Created by Администратор on 01.02.2017.
 */
public interface IPlanetsListView {
    void showListPeople(List<Planets> items);
    void showEmptyList();
    void showError(String error);
}
