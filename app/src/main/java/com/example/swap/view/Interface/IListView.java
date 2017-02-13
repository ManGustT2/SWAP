package com.example.swap.view.Interface;

import java.util.List;

/**
 * Created by Администратор on 09.02.2017.
 */

public interface IListView<T> {
    void showList(List<T> items);
    void showEmptyList();
    void showError(String error);
}
