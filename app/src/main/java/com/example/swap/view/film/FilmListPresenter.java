package com.example.swap.view.film;

import com.example.swap.base.BasePresenter;
import com.example.swap.data.api.database.IFilmRepo;
import com.example.swap.data.api.model.FilmsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Администратор on 22.12.2016.
 */
public class FilmListPresenter extends BasePresenter {
    private IFilmListView mView;
    private IFilmRepo mIFilmRepo;

    public FilmListPresenter(IFilmListView _view, IFilmRepo IFilmRepo) {
        mView = _view;
        mIFilmRepo = IFilmRepo;

    }

    public void getFilmList() {
        restClient.getFilms().enqueue(new Callback<FilmsResponse>() {
            @Override
            public void onResponse(Call<FilmsResponse> call, Response<FilmsResponse> response) {
                if(response.body() == null || response.body().getResults().isEmpty()) {
                    mView.showEmptyList();
                } else {
                    mIFilmRepo.insertFilms(response.body().getResults());
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
