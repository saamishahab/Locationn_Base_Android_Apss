package com.saami.locationbaseserviceapps.ui.location;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.saami.locationbaseserviceapps.R;
import com.saami.locationbaseserviceapps.databinding.FragmentHomeBinding;
import com.saami.locationbaseserviceapps.databinding.FragmentLocationBinding;

public class LocationFragment extends Fragment implements OnMapReadyCallback
{


    private FragmentLocationBinding binding;

    private GoogleMap mMap;

    public View onCreateView (@NonNull LayoutInflater inflater,
                              ViewGroup container, Bundle savedInstanceState)
    {

        binding = FragmentLocationBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        return root;
    }

    @Override
    public void onMapReady (GoogleMap googleMap)
    {
        mMap = googleMap;

        LatLng jakarta = new LatLng(-6.1754301, 106.8271843);
        mMap.addMarker(new MarkerOptions().position(jakarta).title("Monumen Nasional (Jakarta)"));

        LatLng istiqlal = new LatLng(-6.1702217, 106.831398);
        mMap.addMarker(new MarkerOptions().position(istiqlal).title("Masjid Istiqlal"));

        LatLng dufan = new LatLng(-6.125346,106.8340528);
        mMap.addMarker(new MarkerOptions().position(dufan).title("Dunia Fantasi"));




        mMap.moveCamera(CameraUpdateFactory.newLatLng(jakarta));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener()
        {
            @Override
            public boolean onMarkerClick (Marker marker)
            {
                Toast.makeText(LocationFragment.this.getActivity(), marker.getTitle(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

}