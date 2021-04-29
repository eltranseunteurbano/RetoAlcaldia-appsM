package com.example.alcaldia;

import com.google.android.gms.maps.model.LatLng;

public class LocationLM {
    private String name;
    private LatLng latLng;

    public LocationLM() {
    }

    public LocationLM(String name, LatLng latLng) {
        this.name = name;
        this.latLng = latLng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }
}
