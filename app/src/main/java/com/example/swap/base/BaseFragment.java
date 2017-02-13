package com.example.swap.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.swap.data.api.database.DbHelper;

/**
 * Created by Администратор on 14.12.2016.
 */
public abstract class BaseFragment extends Fragment{

    DbHelper mDbHelper;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayoutInflater(), container, false);
        findUI(rootView);
        setupUI();
        mDbHelper = new DbHelper(getContext());
        return rootView;
    }

    public abstract int getLayoutInflater();

    public abstract void findUI(View rootView);

    public abstract void setupUI();
}
