package com.example.alcaldia.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alcaldia.R;

public class SearchFragment extends Fragment {

    private RecyclerView recyclerView;
    private TextView nombreBuscar;


    public SearchFragment() {}

    public static SearchFragment newInstance(){
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root =  inflater.inflate(R.layout.fragment_search, container, false);
        recyclerView = root.findViewById(R.id.recyclerView);
        nombreBuscar = root.findViewById(R.id.nombreBuscar);



        return root;
    }
}
