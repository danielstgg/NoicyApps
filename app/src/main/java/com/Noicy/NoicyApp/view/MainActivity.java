package com.Noicy.NoicyApp.view;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.Noicy.NoicyApp.R;
import com.Noicy.NoicyApp.view.feed.FeedFragment;
import com.Noicy.NoicyApp.view.tshirt.TshirtFragment;
import com.Noicy.NoicyApp.view.about.AboutFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(this);
        loadFragment(new TshirtFragment());
    }

    void loadFragment(Fragment fragment){
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container,fragment);
        ft.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.navigation_feed:
                loadFragment(new FeedFragment());
                return  true;
            case R.id.navigation_tshirt:
                loadFragment(new TshirtFragment());
                return  true;
            case R.id.navigation_about:
                loadFragment(new AboutFragment());
                return  true;

        }
        return false;
    }
}
