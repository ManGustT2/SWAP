package com.example.swap.view.films;

import android.content.Context;

import com.example.swap.base.BasePresenter;
import com.example.swap.data.api.database.DbHelper;
import com.example.swap.data.api.model.Film;
import com.example.swap.data.api.model.response.ResponseModel;
import com.example.swap.view.Interface.IListView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmListPresenter extends BasePresenter {

    private IListView mView;
    private DbHelper mHelper;

    public FilmListPresenter(IListView _view, Context _context) {
        mView = _view;
        mHelper = new DbHelper(_context);
    }

    public void getFilmList() {
        mView.showList(mHelper.getListFilm());
        restClient.getFilms().enqueue(new Callback<ResponseModel<Film>>() {
            @Override
            public void onResponse(Call<ResponseModel<Film>> call, Response<ResponseModel<Film>> response) {
                if(response.body() == null || response.body().getResults().isEmpty()) {
                    mView.showEmptyList();
                } else {
                    mHelper.insertFilms(response.body().getResults());
                    mView.showList(mHelper.getListFilm());
                }
            }

            @Override
            public void onFailure(Call<ResponseModel<Film>> call, Throwable t) {
                mView.showError(t.getMessage());
            }
        });
    }
}
