package com.example.seeker;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;



public class AdminActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        final FragmentManager fragmentManager = getSupportFragmentManager();

        // define your fragments here
        final Fragment userfragment = new UserFragment();
        //final Fragment fragment2 = new SecondFragment();
        //final Fragment fragment3 = new ThirdFragment();

        // handle navigation selection

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.menu);

        bottomNavigationView.setOnNavigationItemSelectedListener( new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        Fragment fragment;
                        switch (item.getItemId()) {
                            case R.id.action_users:
                                fragment = userfragment;
                                break;
                            case R.id.action_businesses:
                               // fragment = fragment2;
                               // break;
                            case R.id.action_reviews:
                            default:
                                fragment = userfragment;
                                break;
                        }
                        fragmentManager.beginTransaction().replace(R.id.flContainer2, fragment).commit();
                        return true;
                    }
                });
        // Set default selection
        bottomNavigationView.setSelectedItemId(R.id.action_users);
    }
}


