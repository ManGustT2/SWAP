package com.example.swap.view.spesies;

import com.example.swap.data.api.model.Species;

import java.util.List;

/**
 * Created by Администратор on 01.02.2017.
 */
public interface ISpesciesListView {
    void showListPeople(List<Species> items);
    void showEmptyList();
    void showError(String error);
}
