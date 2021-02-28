package com.example.alcaldia.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.alcaldia.R;

public class BussinessFragment extends Fragment {

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
        return inflater.inflate(R.layout.fragment_bussines, container, false);
    }
}
