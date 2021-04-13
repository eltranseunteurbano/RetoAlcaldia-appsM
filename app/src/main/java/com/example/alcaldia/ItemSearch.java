package com.example.alcaldia;

import android.widget.ImageView;

public class ItemSearch {
  private String id;
  private String name;
  private Double rate;
  private int image;
  
  public ItemSearch ( String id, String name, Double rate, int image ) {
    this.id = id;
    this.name = name;
    this.rate = rate;
    this.image = image;
  }
  
  public  ItemSearch () {
  
  }
  
  public String getId () {
    return id;
  }
  
  public void setId ( String id ) {
    this.id = id;
  }
  
  public String getName () {
    return name;
  }
  
  public void setName ( String name ) {
    this.name = name;
  }
  
  public Double getRate () {
    return rate;
  }
  
  public void setRate ( Double rate ) {
    this.rate = rate;
  }
  
  public int getImage () {
    return image;
  }
  
  public void setImage ( int image ) {
    this.image = image;
    
  }
}
