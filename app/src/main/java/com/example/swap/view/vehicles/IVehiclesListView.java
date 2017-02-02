package com.example.swap.view.vehicles;

import com.example.swap.data.api.model.Vehicles;

import java.util.List;

/**
 * Created by Администратор on 01.02.2017.
 */
public interface IVehiclesListView {

    void showListPeople(List<Vehicles> items);
    void showEmptyList();
    void showError(String error);

}
