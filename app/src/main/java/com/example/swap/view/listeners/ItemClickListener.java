package com.example.swap.view.listeners;

/**
 * Created by Администратор on 15.12.2016.
 */
public interface ItemClickListener<T> {
    void onItemLongClicked(T item);

    void onItemClick(T item);
    }
