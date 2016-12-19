package com.example.swap.base;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 15.12.2016.
 */
public abstract class BaceRecycleViewAdapter <Film, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    private List<Film> list;

    public BaceRecycleViewAdapter() {
        this.list = new ArrayList<>(0);
    }

    @Override
    public abstract VH onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(VH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public List<Film> getList() {
        return list;
    }

    public void setList(List<Film> list) {
        this.list = list;
    }

    public abstract void update(List<Film> items);

    public abstract void apply(List<Film> all);

}
