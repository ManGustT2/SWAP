package com.example.swap.view.fragments;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.swap.R;
import com.example.swap.base.BaseFragment;
import com.example.swap.data.api.model.Film;
import com.example.swap.data.api.model.FilmsResponse;
import com.example.swap.view.activity.SWAPActivity;
import com.example.swap.view.adapters.FilmRecycleViewAdapter;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Администратор on 15.12.2016.
 */
public class FilmListFragment extends BaseFragment {

    private SWAPActivity mSWAPActivity;
    private RecyclerView mRecyclerView;
    private FilmRecycleViewAdapter mFilmRecycleViewAdapter;

    private ItemClickListener<Film> mItemClickListener = new ItemClickListener<Film>() {
        @Override
        public void onItemLongClicked(Film item) {
        }

        @Override
        public void onItemClick(Film item) {
        }
    };

    private List<Film> mFilmList = new ArrayList<>();

    @Override
    public int getLayoutInflater() {
        return R.layout.fragment_films_list;
    }

    @Override
    public void findUI(View rootView) {
        mFilmRecycleViewAdapter = new FilmRecycleViewAdapter(mItemClickListener);
        mFilmRecycleViewAdapter.apply(mFilmList);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mFilmRecycleViewAdapter);

    }

    // TODO: 17.12.2016 почему не можем обработать mItemClickListener

    @Override
    public void setupUI() {
        restClient.getFilms().enqueue(new Callback<FilmsResponse>() {
            @Override
            public void onResponse(Call<FilmsResponse> call, Response<FilmsResponse> response) {
                if(response.body() != null){
                    mFilmList = response.body().getResults();
                }else {
                }
            }

            @Override
            public void onFailure(Call<FilmsResponse> call, Throwable t) {
            }
        });
    }
}
