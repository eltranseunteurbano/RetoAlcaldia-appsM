package com.example.alcaldia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.UUID;

public class ItemSearchAdapter extends RecyclerView.Adapter<ItemSearchView> {
  private ArrayList<ItemSearch> itemsSearch;
  
  public ItemSearchAdapter () {
    itemsSearch = new ArrayList<>();
  
    itemsSearch.add(new ItemSearch(UUID.randomUUID().toString(), "Estadio pascual guerrero", 4.0,  R.drawable.pascualGuerrero_background ));
    itemsSearch.add(new ItemSearch(UUID.randomUUID().toString(), "Tardes caleñas", 4.2, R.drawable.pascualGuerrero_background ));
    itemsSearch.add(new ItemSearch(UUID.randomUUID().toString(), "Universidad Icesi", 3.2, R.drawable.pascualGuerrero_background));
  }
  
  public void addItemSearch(ItemSearch itemSearch){
    itemsSearch.add(itemSearch);
  }
  
  @NonNull
  @Override
  public ItemSearchView onCreateViewHolder ( @NonNull ViewGroup parent, int viewType ) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    View row = inflater.inflate(R.layout.item_search_row, null);
    ConstraintLayout rowroot = (ConstraintLayout) row;
    ItemSearchView itemSearchView = new ItemSearchView(rowroot);
    return itemSearchView;
  }
  
  @Override
  public void onBindViewHolder ( @NonNull ItemSearchView holder, int position ) {
    holder.getName().setText(itemsSearch.get(position).getName());
    holder.getRate().setText(itemsSearch.get(position).getRate().toString());
    holder.getImage().setImageResource(itemsSearch.get(position).getImage());
  }
  
  @Override
  public int getItemCount () {
    return itemsSearch.size();
  }
  
}
