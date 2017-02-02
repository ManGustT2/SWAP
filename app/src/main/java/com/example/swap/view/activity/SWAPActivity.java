package com.example.swap.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.swap.R;
import com.example.swap.base.BaseFragment;
import com.example.swap.view.films.FilmListFragment;

public class SWAPActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, ISwapView{
    private static final String TAG = "TAG";
    private FragmentManager mFragmentManager;
    private Toolbar mToolbar;
    private ActionBarDrawerToggle mBarDrawerToggle;
    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;
    private SwapPresenter mSwapPresenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swap);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        mSwapPresenter = new SwapPresenter(this);
        mNavigationView.setNavigationItemSelectedListener(this);
        mBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.openDrawer, R.string.closeDrawer);
        mDrawerLayout.addDrawerListener(mBarDrawerToggle);
        mBarDrawerToggle.syncState();
        mBarDrawerToggle.setDrawerIndicatorEnabled(true);
        mBarDrawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        getSupportFragmentManager()
                .addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                mBarDrawerToggle.setDrawerIndicatorEnabled(getSupportFragmentManager().getBackStackEntryCount() == 0);
                getSupportActionBar().setDisplayHomeAsUpEnabled(getSupportFragmentManager().getBackStackEntryCount() > 0);
                mBarDrawerToggle.syncState();
            }
        });

        mFragmentManager = getSupportFragmentManager();

        Fragment fragment = mFragmentManager.findFragmentById(R.id.frame);

        if (fragment == null)
            replaceFragment(new FilmListFragment(), false);
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        mSwapPresenter.onMenuItemClick(id);
        return true;
    }




    public void replaceFragment(Fragment fragment, boolean isBackStack) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction()
                .replace(R.id.frame, fragment);
        if(isBackStack)
            transaction.addToBackStack(null);
        transaction.commit();
    }
    @Override
    public void onBackPressed(){
    }

    @Override
    public void changeFragment(BaseFragment _fragment) {
        replaceFragment(_fragment, false);
    }
}
