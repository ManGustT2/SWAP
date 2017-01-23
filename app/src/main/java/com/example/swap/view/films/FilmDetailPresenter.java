package com.example.swap.view.films;

import android.content.Context;

import com.example.swap.base.BasePresenter;
import com.example.swap.data.api.database.DBHelper;

/**
 * Created by Администратор on 09.01.2017.
 */
public class FilmDetailPresenter extends BasePresenter{

    private FilmDetailView mFilmDetailView;
    private DBHelper mHelper;


    public FilmDetailPresenter(DetailListFragment _view, Context context) {
        mFilmDetailView = _view;
        mHelper = new DBHelper(context);
    }

    public void getDetailFilm(){
        mFilmDetailView.showDetailFilm(mHelper.getDetailFilm(mFilmDetailView.getArgs()));
    }

}
