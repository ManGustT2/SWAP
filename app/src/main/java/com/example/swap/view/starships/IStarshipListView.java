package com.example.swap.view.starships;

import com.example.swap.data.api.model.Starships;

import java.util.List;

/**
 * Created by Администратор on 01.02.2017.
 */
public interface IStarshipListView {
    void showListPeople(List<Starships> items);
    void showEmptyList();
    void showError(String error);
}
