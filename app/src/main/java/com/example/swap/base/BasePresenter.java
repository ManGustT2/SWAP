package com.example.swap.base;

import com.example.swap.data.api.retrofit.RestClient;
import com.example.swap.data.api.retrofit.RetrofitInterface;

/**
 * Created by Администратор on 22.12.2016.
 */
public class BasePresenter {
    protected RetrofitInterface restClient = RestClient.getRetrofitAdapter();
}
