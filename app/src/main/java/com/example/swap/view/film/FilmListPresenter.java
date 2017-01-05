package com.example.swap.view.film;

import android.content.Context;

import com.example.swap.base.BasePresenter;
import com.example.swap.data.api.database.FeedReaderDbHelper;
import com.example.swap.data.api.model.FilmsResponse;
import com.example.swap.data.api.retrofit.RestClient;
import com.example.swap.data.api.retrofit.RetrofitInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Администратор on 22.12.2016.
 */
public class FilmListPresenter extends BasePresenter {
    private IFilmListView mView;
    private FeedReaderDbHelper mHelper;

    public FilmListPresenter(IFilmListView _view, Context _context) {
        mView = _view;
        mHelper = new FeedReaderDbHelper(_context);

    }

    public void getFilmList() {
        restClient.getFilms().enqueue(new Callback<FilmsResponse>() {
            @Override
            public void onResponse(Call<FilmsResponse> call, Response<FilmsResponse> response) {
                if(response.body() == null || response.body().getResults().isEmpty()) {
                    mView.showEmptyList();
                } else {
                    mView.showListFilms(response.body().getResults());
                    mView.showListFilms(response.body().getResults());
                }
            }

            @Override
            public void onFailure(Call<FilmsResponse> call, Throwable t) {
                mView.showError(t.getMessage());
            }
        });
    }
}
