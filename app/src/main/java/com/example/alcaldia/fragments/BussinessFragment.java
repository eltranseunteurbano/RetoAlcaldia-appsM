   package com.example.alcaldia.fragments;

import android.Manifest;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.alcaldia.MainActivity;
import com.example.alcaldia.R;
import com.example.alcaldia.UtilDomi;
import com.google.android.material.textfield.TextInputLayout;

import java.io.File;

import static android.app.Activity.RESULT_OK;

public class BussinessFragment extends Fragment implements View.OnClickListener {

    private TextInputLayout map_direction_bussinesF;
    private ImageButton mapButton;
    private ImageButton imageButtonadd;
    private ImageView imageDirection;
    private TextView textDirection;
    private Button buttonRegister;
    private static String direction;
    private MapsFragment mapFragment;
    private String path =null;
    public static final int GALLERY_CALLBACK = 11;


    public BussinessFragment() {}

    public static BussinessFragment newInstance(){
        BussinessFragment fragment = new BussinessFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.fragment_bussines, container, false);

        map_direction_bussinesF = root.findViewById(R.id.map_direction_bussinesF);
        imageButtonadd = root.findViewById(R.id.imageButtonadd);
        imageDirection = root.findViewById(R.id.imageDirection);
        textDirection = root.findViewById(R.id.textDirection);
        mapFragment = MapsFragment.newInstance();

        mapButton = root.findViewById(R.id.mapButton);
        mapButton.setOnClickListener(this);

        buttonRegister = root.findViewById(R.id.buttonRegister);
        direction = map_direction_bussinesF.getEditText().toString();

        if(path != null){
            Bitmap bitmap = BitmapFactory.decodeFile(path);
            imageDirection.setImageBitmap((bitmap));
        }

        imageButtonadd.setOnClickListener(
                v->{
                    Intent j = new Intent((Intent.ACTION_GET_CONTENT));
                    j.setType(("image/*"));
                    startActivityForResult(j, GALLERY_CALLBACK);
                }
        );

        return root;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.mapButton:
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_content, mapFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            case R.id.imageButtonadd:
                /*fragmentTransaction.
                file = new File(getExternalFilesDir())
                Intent i = new Intent(view.getContext(), MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(i);*/
                break;
        }



    }

    public interface OnNewMap{
        void onNewMap(String direction);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== RESULT_OK && requestCode == GALLERY_CALLBACK){
            Uri uri = data.getData();
            path = UtilDomi.getPath(getActivity(), uri);
            Bitmap imagebn = BitmapFactory.decodeFile(path);
            imageDirection.setImageBitmap(imagebn);
        }
    }
}
