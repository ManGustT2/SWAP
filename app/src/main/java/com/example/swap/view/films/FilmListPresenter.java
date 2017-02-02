package com.example.swap.view.films;

import android.content.Context;

import com.example.swap.base.BasePresenter;
import com.example.swap.data.api.database.DBHelper;
import com.example.swap.data.api.model.response.FilmsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Администратор on 22.12.2016.
 */
public class FilmListPresenter extends BasePresenter {
    private IFilmListView mView;
    private DBHelper mHelper;

    public FilmListPresenter(IFilmListView _view, Context _context) {
        mView = _view;
        mHelper = new DBHelper(_context);

    }

    public void getFilmList() {
        mView.showListFilms(mHelper.getListFilm());
        restClient.getFilms().enqueue(new Callback<FilmsResponse>() {
            @Override
            public void onResponse(Call<FilmsResponse> call, Response<FilmsResponse> response) {
                if(response.body() == null || response.body().getResults().isEmpty()) {
                    mView.showEmptyList();
                } else {
                    mHelper.insertFilms(response.body().getResults());
                    mView.showListFilms(mHelper.getListFilm());
                }
            }

            @Override
            public void onFailure(Call<FilmsResponse> call, Throwable t) {
                mView.showError(t.getMessage());
            }
        });
    }
}
