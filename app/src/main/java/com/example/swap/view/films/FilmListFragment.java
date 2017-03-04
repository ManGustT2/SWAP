package com.example.swap.view.films;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import com.example.swap.R;
import com.example.swap.base.BaseFragment;
import com.example.swap.data.api.model.Film;
import com.example.swap.view.Interface.IListView;
import com.example.swap.view.activity.SWAPActivity;
import com.example.swap.view.adapters.FilmRecycleViewAdapter;
import com.example.swap.view.listeners.ItemClickListener;

import java.util.ArrayList;
import java.util.List;


public class FilmListFragment extends BaseFragment implements IListView {
    private FilmListPresenter mPresenter;
    private RecyclerView mRecyclerView;
    private FilmRecycleViewAdapter mFilmRecycleViewAdapter;
    private SWAPActivity mSWAPActivity;

    private ItemClickListener<Film> mItemClickListener = new ItemClickListener<Film>() {
        @Override
        public void onItemLongClicked(Film item) {
        }

        @Override
        public void onItemClick(Film item) {
            mSWAPActivity.replaceFragment(DetailListFragment.newInstance(item.getEpisode_id()), true);
        }
    };

    @Override
    public int getLayoutInflater() {
        return R.layout.fragment_list;
    }

    @Override
    public void findUI(View rootView) {
        mFilmRecycleViewAdapter = new FilmRecycleViewAdapter(mItemClickListener);
        mFilmRecycleViewAdapter.apply(new ArrayList<Film>());
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mFilmRecycleViewAdapter);

    }

    @Override
    public void setupUI() {
        FilmListPresenter presenter = new FilmListPresenter(this, getActivity());
        presenter.getFilmList();
    }



    @Override
    public void showList(List items) {
        mFilmRecycleViewAdapter.update(items);
    }

    @Override
    public void showEmptyList() {
        mFilmRecycleViewAdapter.update(new ArrayList<Film>());
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getActivity(), String.format("Error: %s", error), Toast.LENGTH_LONG).show();
    }
}
