package com.example.swap.view.fragments;

/**
 * Created by Администратор on 15.12.2016.
 */
public interface ItemClickListener<Film> {
        void onItemLongClicked(Film item);

        void onItemClick(Film item);
    }
