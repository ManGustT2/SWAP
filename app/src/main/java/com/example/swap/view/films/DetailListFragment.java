package com.example.swap.view.films;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.swap.R;
import com.example.swap.base.BaseFragment;
import com.example.swap.data.api.model.Film;


public class DetailListFragment extends BaseFragment implements FilmDetailView {
    private static final String TAG = "DetailListFragment";
    private TextView mTitle;
    private TextView mDateReleace;
    private int mEpisode;
    private TextView mOpenCrawl;
    private FilmDetailPresenter mPresenter;


    @Override
    public int getLayoutInflater() {
        return R.layout.fragment_detail_film;

    }

    public static DetailListFragment newInstance(int episode_id) {

        Bundle args = new Bundle();
        args.putInt(TAG, episode_id);
        DetailListFragment fragment = new DetailListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public int getArgs(){
        mEpisode = getArguments().getInt(TAG);
        return mEpisode;
    }

    @Override
    public void findUI(View rootView) {
        mTitle = (TextView) rootView.findViewById(R.id.titleFDF);
        mDateReleace = (TextView) rootView.findViewById(R.id.release_dateFDF);
        mOpenCrawl = (TextView) rootView.findViewById(R.id.opening_crawlFDF);

    }


    @Override
    public void setupUI() {
        mPresenter = new FilmDetailPresenter(this, getActivity());
        mPresenter.getDetailFilm();
    }

    @Override
    public void showDetailFilm(Film item) {
        mTitle.setText(item.getTitle());
        mDateReleace.setText(item.getRelease_date());
        mOpenCrawl.setText(item.getOpening_crawl());
    }
}
