package com.example.swap.view.planets;

import java.util.List;

/**
 * Created by Администратор on 01.02.2017.
 */
public interface IPlanetsListView<T> {
    void showListPeople(List<T> items);
    void showEmptyList();
    void showError(String error);
}
