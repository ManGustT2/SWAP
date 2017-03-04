package com.example.swap.view.people;

import android.content.Context;
import com.example.swap.base.BasePresenter;
import com.example.swap.data.api.model.People;
import com.example.swap.data.api.model.response.ResponseModel;
import com.example.swap.view.Interface.IListView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Администратор on 01.02.2017.
 */
public class PeopleListPresenter extends BasePresenter{

    private IListView mView;


    public PeopleListPresenter(IListView m_View, Context context) {
        mView = m_View;
    }

    public void getPeopleList(){
        restClient.getPeople().enqueue(new Callback<ResponseModel<People>>() {
            @Override
            public void onResponse(Call<ResponseModel<People>> call, Response<ResponseModel<People>> response) {
                if (response.body().getResults().isEmpty()){
                    mView.showList(response.body().getResults());
                }
            }

            @Override
            public void onFailure(Call<ResponseModel<People>> call, Throwable t) {
                mView.showError(t.getMessage());
            }
        });

    }
}
