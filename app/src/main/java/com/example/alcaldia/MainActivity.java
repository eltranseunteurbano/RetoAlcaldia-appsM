    package com.example.alcaldia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.transition.Scene;
import android.widget.Toast;

import com.example.alcaldia.fragments.BussinessFragment;
import com.example.alcaldia.fragments.MapsFragment;
import com.example.alcaldia.fragments.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BussinessFragment bussinessFragment;
    private MapsFragment mapFragment;
    private SearchFragment searchFragment;
    private Scene scene;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bussinessFragment = BussinessFragment.newInstance();
        mapFragment = MapsFragment.newInstance();
        searchFragment = SearchFragment.newInstance();

        BottomNavigationView bottomNavigationView = findViewById(R.id.buttom_navigation);

        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
        }, 1);

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

   /* @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==PERMISSIONS_CALLBACK){
            boolean allGrant = true;
            for(int i =0; i<grantResults.length;i++){
                if(grantResults[i]== PackageManager.PERMISSION_DENIED){
                    allGrant=false;
                    break;
                }
            }
            if(allGrant){
                Toast.makeText(this,"todos los permisos concedidos", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(this,"Alerta, no todos los permisos concedidos", Toast.LENGTH_LONG).show();
            }

        }
    }*/

}