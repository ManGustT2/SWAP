package com.example.swap.view.people;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.swap.base.BaseFragment;
import com.example.swap.data.api.model.People;
import com.example.swap.view.films.FilmListPresenter;

import java.util.List;

/**
 * Created by Администратор on 26.01.2017.
 */
public class PeoleFragment extends BaseFragment implements IPeopleListView {

    private PeopleListPresenter mPresenter;
    private RecyclerView mRecyclerView;
    private RecycleViewAdapter mFilmRecycleViewAdapter;


    @Override
    public int getLayoutInflater() {
        return 0;
    }

    @Override
    public void findUI(View rootView) {

    }

    @Override
    public void setupUI() {

    }

    @Override
    public void showListPeople(List<People> items) {

    }

    @Override
    public void showEmptyList() {

    }

    @Override
    public void showError(String error) {

    }
}
