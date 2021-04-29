package com.example.alcaldia.fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alcaldia.LocationLM;
import com.example.alcaldia.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import static android.content.Context.LOCATION_SERVICE;
import static android.location.LocationManager.GPS_PROVIDER;

public class MapsFragment extends Fragment /*implements GoogleMap.OnMapLongClickListener*/ {

    private LocationManager locationManager;
    private GoogleMap mMap;
    private Marker myMarket;
    private String directionUbication;
    private ArrayList<LocationLM> listUbication;


    public static MapsFragment newInstance(){
        MapsFragment fragment = new MapsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        locationManager=(LocationManager) getActivity().getSystemService(LOCATION_SERVICE);
        initLocation();
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    public Marker getMyMarket() {
        return myMarket;
    }

    private final OnMapReadyCallback callback = new OnMapReadyCallback() {

        @Override
        @SuppressLint("MissingPermission")
        public void onMapReady(GoogleMap googleMap) {
            LatLng col = new LatLng(3, -74);
            googleMap.addMarker(new MarkerOptions().position(col).title("Colombia"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(col));
            mMap = googleMap;
            myMarket = mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)));
            mMap.setMyLocationEnabled(true);
            mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                @Override
                public void onMapClick(LatLng latLng) {
                    Marker p = myMarket = mMap.addMarker(new MarkerOptions().position(latLng));
                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,8));
                }
            });
            //mMap.setOnMapLongClickListener(this);
            Location location = locationManager.getLastKnownLocation(GPS_PROVIDER);
            initLocation();
            //directionUbication= myMarket.get
        }
    };

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }

    }

    public ArrayList<LocationLM> getListUbication() {
        return listUbication;
    }

    @SuppressLint("MissingPermission")
    private void initLocation() {
        locationManager.requestLocationUpdates(
                GPS_PROVIDER,
                1000, 2,
                new LocationListener() {
                    @Override
                    public void onLocationChanged(@NonNull Location location) {
                        location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                        LatLng pos= new LatLng(location.getLatitude(),location.getLongitude());
                        mMap.addMarker((new MarkerOptions().position(pos).title("")));
                        myMarket.setPosition(pos);
                        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(pos,16));
                        updateMyLocation(location);

                    }
                    @Override
                    public void onStatusChanged(String provider, int status, Bundle extras) {}

                    @Override
                    public void onProviderEnabled(@NonNull String provider) {}

                    @Override
                    public void onProviderDisabled(@NonNull String provider) {}
                });
    }

    public void updateMyLocation(Location location){
        LatLng pos= new LatLng(location.getLatitude(),location.getLongitude());
        if(myMarket==null){
            myMarket= mMap.addMarker(new MarkerOptions().position(pos).title(""));
        }else{
            myMarket.setPosition(pos);
        }
        mMap.animateCamera(CameraUpdateFactory.newLatLng(pos));
    }

    /*
    public void onMapClick(LatLng latLng) {
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,16));
    }

    @Override
    public void onMapLongClick(LatLng latLng) {
        Marker p = myMarket = mMap.addMarker(new MarkerOptions().position(latLng));

    }*/
}