package com.example.swap.view.people;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.swap.R;
import com.example.swap.base.BaseFragment;
import com.example.swap.data.api.model.People;
import com.example.swap.view.Interface.IListView;
import com.example.swap.view.adapters.PeopleRecyclerViewAdapter;
import com.example.swap.view.listeners.ItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class PeopleFragment extends BaseFragment implements IListView {


    private RecyclerView mRecyclerView;
    private PeopleRecyclerViewAdapter mPeopleRecyclerViewAdapter;

    private ItemClickListener<People> mItemClickListener = new ItemClickListener<People>() {
        @Override
        public void onItemLongClicked(People item) {

        }

        @Override
        public void onItemClick(People item) {

        }
    };
    
    @Override
    public int getLayoutInflater() {
        return R.layout.fragment_list;
    }

    @Override
    public void findUI(View rootView) {
        mPeopleRecyclerViewAdapter = new PeopleRecyclerViewAdapter(mItemClickListener);
        mPeopleRecyclerViewAdapter.apply(new ArrayList<People>());
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mPeopleRecyclerViewAdapter);

    }

    @Override
    public void setupUI() {
        PeopleListPresenter presenter = new PeopleListPresenter(this, getActivity());
        presenter.getPeopleList();

    }

    @Override
    public void showList(List items) {
        mPeopleRecyclerViewAdapter.update(items);
    }

    @Override
    public void showEmptyList() {
        mPeopleRecyclerViewAdapter.update(new ArrayList<People>());

    }

    @Override
    public void showError(String error) {
        Toast.makeText(getActivity(), String.format("Error: %s", error), Toast.LENGTH_LONG).show();

    }
}
