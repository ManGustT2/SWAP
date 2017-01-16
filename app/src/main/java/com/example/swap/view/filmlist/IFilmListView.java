package com.example.swap.view.filmlist;

import com.example.swap.data.api.model.Film;

import java.util.List;

/**
 * Created by Администратор on 22.12.2016.
 */
public interface IFilmListView {
    void showListFilms(List<Film> items);
    void showEmptyList();
    void showError(String error);
}
