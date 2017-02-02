package com.example.swap.view.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.swap.base.BaceRecycleViewAdapter;
import com.example.swap.data.api.model.People;

import java.util.List;

/**
 * Created by Администратор on 01.02.2017.
 */
public class PeopleRecyclerViewAdapter extends BaceRecycleViewAdapter<People, PeopleRecyclerViewAdapter.ViewHolder> {

    @Override
    public PeopleRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void apply(List all) {

    }

    @Override
    public void update(List items) {

    }

     class ViewHolder extends RecyclerView.ViewHolder {


         public ViewHolder(View itemView) {
             super(itemView);
         }

    }
}
