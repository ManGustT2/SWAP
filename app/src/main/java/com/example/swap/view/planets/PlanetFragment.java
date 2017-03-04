package com.example.swap.view.planets;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.swap.R;
import com.example.swap.base.BaseFragment;
import com.example.swap.data.api.model.People;
import com.example.swap.data.api.model.Planets;
import com.example.swap.view.Interface.IListView;
import com.example.swap.view.adapters.PeopleRecyclerViewAdapter;
import com.example.swap.view.adapters.PlanetRecyclerViewAdapter;
import com.example.swap.view.listeners.ItemClickListener;
import com.example.swap.view.people.PeopleListPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 26.01.2017.
 */
public class PlanetFragment extends BaseFragment implements IListView{

    private IListView mIListView;
    private RecyclerView mRecyclerView;
    private PlanetRecyclerViewAdapter planetRecyclerViewAdapter;

    private ItemClickListener<Planets> mItemClickListener = new ItemClickListener<Planets>() {
        @Override
        public void onItemLongClicked(Planets item) {

        }

        @Override
        public void onItemClick(Planets item) {

        }
    };

    @Override
    public int getLayoutInflater() {
        return R.layout.fragment_list;
    }

    @Override
    public void findUI(View rootView) {
        planetRecyclerViewAdapter = new PlanetRecyclerViewAdapter(mItemClickListener);
        planetRecyclerViewAdapter.apply(new ArrayList<Planets>());
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(planetRecyclerViewAdapter);

    }

    @Override
    public void setupUI() {
        PlanetsListPresenter presenter = new PlanetsListPresenter(this, getActivity());
        presenter.getPlanetList();

    }

    @Override
    public void showList(List items) {
        planetRecyclerViewAdapter.update(items);
    }

    @Override
    public void showEmptyList() {
        planetRecyclerViewAdapter.update(new ArrayList<Planets>());

    }

    @Override
    public void showError(String error) {
        Toast.makeText(getActivity(), String.format("Error: %s", error), Toast.LENGTH_LONG).show();

    }
}
