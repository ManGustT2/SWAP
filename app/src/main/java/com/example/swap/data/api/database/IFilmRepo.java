package com.example.swap.data.api.database;

import com.example.swap.data.api.model.Film;

import java.util.List;


public interface IFilmRepo {
    void insertFilms(List<Film> _list);
}
