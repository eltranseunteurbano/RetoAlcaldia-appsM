package com.example.alcaldia.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alcaldia.ItemSearchAdapter;
import com.example.alcaldia.R;

public class SearchFragment extends Fragment {

    private RecyclerView placesRecyclerViewList;
    private LinearLayoutManager layoutManager;
    private ItemSearchAdapter adapter;
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
        placesRecyclerViewList = root.findViewById(R.id.placesRecyclerViewList);
        placesRecyclerViewList.setHasFixedSize(true);
        placesRecyclerViewList.setLayoutManager(new LinearLayoutManager(root.getContext()));
        //layoutManager=new LinearLayoutManager(this);


        adapter = new ItemSearchAdapter();
        placesRecyclerViewList.setAdapter(adapter);
        return root;
    }
}
