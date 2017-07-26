package com.example.keshav.projecttcs;

import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity {

    /*private GoogleMap mMap;
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Toast.makeText(getApplicationContext(), "Location services are not on / permissions nahi hai \nRepair and try.", Toast.LENGTH_SHORT).show();

        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

   /* void setmymarker(GoogleMap mMap,LocationManager locationManager)
    { try {
        mMap.setMyLocationEnabled(true);
        Location l = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        if (l == null) {
            Toast.makeText(getApplicationContext(), "Location services are not on / permissions nahi hai \nRepair and try.", Toast.LENGTH_SHORT).show();
        }else {
            LatLng ll = new LatLng(l.getLatitude(), l.getLongitude());


            mMap.addMarker(new MarkerOptions().title("I m here !!").position(ll));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(ll, 10f));
        }
    }
    catch (SecurityException e){
        e.printStackTrace();
    }
    }*/
   /* @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        if(locationManager!=null)
        {setmymarker(mMap,locationManager);}
           else {
        }

        // Add a marker in Sydney and move the camera
     //   LatLng sydney = new LatLng(-34, 151);
       // mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 10.2f));
    }*/
}
