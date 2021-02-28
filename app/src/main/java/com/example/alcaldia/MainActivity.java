package com.example.alcaldia;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Build;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.Slide;

import com.example.alcaldia.fragments.BussinessFragment;
import com.example.alcaldia.fragments.MapFragment;
import com.example.alcaldia.fragments.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BussinessFragment bussinessFragment;
    private MapFragment mapFragment;
    private SearchFragment searchFragment;
    private Scene scene;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bussinessFragment = BussinessFragment.newInstance();
        mapFragment = MapFragment.newInstance();
        searchFragment = SearchFragment.newInstance();

        BottomNavigationView bottomNavigationView = findViewById(R.id.buttom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                option -> {
                    switch (option.getItemId()){
                        case R.id.item_nuevo:
                            showFragment(bussinessFragment);
                            break;
                        case R.id.item_mapa:
                            showFragment(mapFragment);
                            break;
                        case R.id.item_buscar:
                            showFragment(searchFragment);
                            break;
                    }
                    return true;
                }
        );

        showFragment(bussinessFragment);
    }

    public void showFragment(Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.main_content, fragment);
        transaction.commit();
    }
}