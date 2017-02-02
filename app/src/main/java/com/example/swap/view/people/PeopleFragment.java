package com.example.swap.view.people;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.swap.R;
import com.example.swap.base.BaseFragment;
import com.example.swap.data.api.model.People;

import java.util.List;

/**
 * Created by Администратор on 26.01.2017.
 */
public class PeopleFragment extends BaseFragment<PeopleListPresenter> implements IPeopleListView {

    private RecyclerView mRecyclerView;

    @Override
    public int getLayoutInflater() {
        return R.layout.fragment_list;
    }

    @Override
    public void findUI(View rootView) {
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    @Override
    public void setupUI() {
//        mPresenter = new PeopleListPresenter(this, getActivity());
//        mPresenter.getPeopleList();

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
