package com.example.swap.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.swap.R;
import com.example.swap.view.films.FilmListFragment;
import com.mikepenz.materialdrawer.Drawer;

public class SWAPActivity extends AppCompatActivity {
    private static final String TAG = "TAG";
    private FragmentManager mFragmentManager;
    private Toolbar mToolbar;
    private Drawer.Result drawerResult = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swap);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        drawerResult = new Drawer()
//                .withActivity(this)
//                .withToolbar(mToolbar)
//                .withActionBarDrawerToggle(true)
//                .withHeader(R.layout.nav_header_main)
//                .addDrawerItems(
//                        new PrimaryDrawerItem().withName(R.string.drawer_people),
//                        new PrimaryDrawerItem().withName(R.string.drawer_planets),
//                        new PrimaryDrawerItem().withName(R.string.drawer_item_films),
//                        new PrimaryDrawerItem().withName(R.string.drawer_item_species),
//                        new PrimaryDrawerItem().withName(R.string.drawer_item_vehicles),
//                        new PrimaryDrawerItem().withName(R.string.OPEN_STARSHIPS)
//                )
//                .withOnDrawerListener(new Drawer.OnDrawerListener() {
//                    @Override
//                    public void onDrawerOpened(View drawerView) {
//                        InputMethodManager inputMethodManager = (InputMethodManager)SWAPActivity.this.getSystemService(Activity.INPUT_METHOD_SERVICE);
//                        inputMethodManager.hideSoftInputFromWindow(SWAPActivity.this.getCurrentFocus().getWindowToken(), 0);
//                    }
//
//                    @Override
//                    public void onDrawerClosed(View drawerView) {
//
//                    }
//                })
//                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {
//                        if (drawerItem instanceof Nameable){
//                            Toast.makeText(SWAPActivity.this, SWAPActivity.this.getString(((Nameable) drawerItem).getNameRes()), Toast.LENGTH_LONG).show();
//                        }
//                        if(drawerItem instanceof Badgeable){
//                            Badgeable badgeable = (Badgeable) drawerItem;
//                            if (badgeable.getBadge() != null) {
//                                try {
//                                    int badge = Integer.valueOf(badgeable.getBadge());
//                                    if (badge > 0) {
//                                        drawerResult.updateBadge(String.valueOf(badge -1), position);
//
//                                    }
//                                } catch (Exception e) {
//                                    Log.d("text", "Не нажимайте на бейдж содержащий плюс! :");
//                                }
//                            }
//                        }
//                    }
//                })
//                .withOnDrawerItemLongClickListener(new Drawer.OnDrawerItemLongClickListener() {
//                    @Override
//                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {
//                        if(drawerItem instanceof SecondaryDrawerItem) {
//                            Toast.makeText(SWAPActivity.this, SWAPActivity.this.getString(((SecondaryDrawerItem) drawerItem).getNameRes()),Toast.LENGTH_LONG).show();
//                        }
//                        return false;
//                    }
//                })
//                .build();

        mFragmentManager = getSupportFragmentManager();

        Fragment fragment = mFragmentManager.findFragmentById(R.id.container);

        if (fragment == null)
            replaceFragment(new FilmListFragment(), false);
    }

    public void replaceFragment(Fragment fragment, boolean isBackStack) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction()
                .replace(R.id.container, fragment);
        if(isBackStack)
            transaction.addToBackStack(null);
        transaction.commit();
    }
    @Override
    public void onBackPressed(){
        if (drawerResult.isDrawerOpen()) {
            drawerResult.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }
}
