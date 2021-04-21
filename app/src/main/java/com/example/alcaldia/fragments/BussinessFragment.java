package com.example.alcaldia.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.alcaldia.MainActivity;
import com.example.alcaldia.R;
import com.google.android.material.textfield.TextInputLayout;

public class BussinessFragment extends Fragment implements View.OnClickListener {

    private TextInputLayout map_direction_bussinesF;
    private ImageButton mapButton;
    private ImageButton imageButtonadd;
    private ImageView imageDirection;
    private TextView textDirection;
    private Button buttonRegister;
    private static String direction;
    private MapFragment mapFragment;



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
        mapFragment = MapFragment.newInstance();

        mapButton = root.findViewById(R.id.mapButton);
        mapButton.setOnClickListener(this);

        buttonRegister = root.findViewById(R.id.buttonRegister);
        direction = map_direction_bussinesF.getEditText().toString();



        return root;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.mapButton:
                //MainActivity activity = MainActiviy.getActivity();
                //activity.showMapFragment(mapFragment);
                break;
        }

    }

    public interface OnNewMap{
        void onNewMap(String direction);
    }
}
