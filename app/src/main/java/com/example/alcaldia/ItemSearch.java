package com.example.alcaldia;

public class ItemSearch {
  private String id;
  private String name;
  private Double rate;
  private String image;
  
  public ItemSearch ( String id, String name, Double rate, String image ) {
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
  
  public String getImage () {
    return image;
  }
  
  public void setImage ( String image ) {
    this.image = image;
  }
}
