package com.example.swap.view.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.swap.R;
import com.example.swap.view.filmlist.FilmListFragment;

public class SWAPActivity extends AppCompatActivity {
    private static final String TAG = "TAG";
    private FragmentManager mFragmentManager;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swap);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mFragmentManager = getSupportFragmentManager();

        Fragment fragment = mFragmentManager.findFragmentById(R.id.container);

        if (fragment == null)
            replaceFragment(new FilmListFragment());
    }

    public void replaceFragment(Fragment fragment) {
        mFragmentManager.beginTransaction()
                .add(R.id.container, fragment)
                .commit();
    }
}
