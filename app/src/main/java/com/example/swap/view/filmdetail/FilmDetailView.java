package com.example.swap.view.filmdetail;

import com.example.swap.data.api.model.Film;

/**
 * Created by Администратор on 14.01.2017.
 */
public interface FilmDetailView {
    void showDetailFilm(Film item);
    int getArgs();
}
