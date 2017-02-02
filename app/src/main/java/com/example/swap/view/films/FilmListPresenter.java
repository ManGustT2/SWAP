package com.example.swap.view.films;

import android.content.Context;

import com.example.swap.base.BasePresenter;
import com.example.swap.data.api.database.DbHelper;
import com.example.swap.data.api.model.response.FilmsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmListPresenter extends BasePresenter {
    private IFilmListView mView;
    private DbHelper mHelper;

    public FilmListPresenter(IFilmListView _view, Context _context) {
        mView = _view;
        mHelper = new DbHelper(_context);

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
