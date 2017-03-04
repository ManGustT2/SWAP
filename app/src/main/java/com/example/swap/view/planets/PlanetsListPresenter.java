package com.example.swap.view.planets;

import android.content.Context;

import com.example.swap.base.BasePresenter;
import com.example.swap.data.api.model.Planets;
import com.example.swap.data.api.model.response.ResponseModel;
import com.example.swap.view.Interface.IListView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Администратор on 01.02.2017.
 */
public class PlanetsListPresenter extends BasePresenter{

    private IListView mView;

    public PlanetsListPresenter(IListView m_View, Context context) {
        mView = m_View;

    }

    public void getPlanetList(){
        restClient.getPlanets().enqueue(new Callback<ResponseModel<Planets>>() {
            @Override
            public void onResponse(Call<ResponseModel<Planets>> call, Response<ResponseModel<Planets>> response) {
                if (response.body().getResults().isEmpty()){
                    mView.showList(response.body().getResults());
                }
            }

            @Override
            public void onFailure(Call<ResponseModel<Planets>> call, Throwable t) {
                mView.showError(t.getMessage());
            }
        });
    }
}
