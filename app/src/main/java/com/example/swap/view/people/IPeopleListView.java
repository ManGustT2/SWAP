package com.example.swap.view.people;

import com.example.swap.data.api.model.People;

import java.util.List;

/**
 * Created by Администратор on 01.02.2017.
 */
public interface IPeopleListView {
    void showListPeople(List<People> items);
    void showEmptyList();
    void showError(String error);
}
