package com.example.alcaldia;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class ItemSearchView extends RecyclerView.ViewHolder {
  private ConstraintLayout root;
  private TextView name;
  private TextView rate;
  private TextView image;
  
  public ItemSearchView ( ConstraintLayout root ) {
    super(root);
    this.root = root;
    name = root.findViewById(R.id.item_search_item_name);
    rate = root.findViewById(R.id.item_search_item_rate);
  }
  
  public ConstraintLayout getRoot () {
    return root;
  }
  
  public void setRoot ( ConstraintLayout root ) {
    this.root = root;
  }
  
  public TextView getName () {
    return name;
  }
  
  public void setName ( TextView name ) {
    this.name = name;
  }
  
  public TextView getRate () {
    return rate;
  }
  
  public void setRate ( TextView rate ) {
    this.rate = rate;
  }
}
