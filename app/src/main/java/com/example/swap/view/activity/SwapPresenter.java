package com.example.swap.view.activity;

import com.example.swap.R;
import com.example.swap.base.BasePresenter;
import com.example.swap.view.films.FilmListFragment;
import com.example.swap.view.people.PeopleFragment;
import com.example.swap.view.planets.PlanetFragment;

/**
 * Created by Администратор on 02.02.2017.
 */
public class SwapPresenter extends BasePresenter {
    private ISwapView mView;


    public SwapPresenter(ISwapView _view){
        mView = _view;
    }

    public void onMenuItemClick(int id){
        switch (id){
            case R.id.nav_people:
                mView.changeFragment(new PeopleFragment());
                break;
            case R.id.nav_movies:
                mView.changeFragment(new FilmListFragment());
                break;
            case R.id.nav_planets:
                mView.changeFragment(new PlanetFragment());
        }
    }
}
