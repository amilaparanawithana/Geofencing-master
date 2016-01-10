package com.google.android.gms.location.sample.geofencing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.location.Geofence;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by thakshilad on 4/11/2015.
 */
public class EditItemActivity extends FragmentActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        fillView();

    }

    private void fillView(){
        int itemToView = LayoutChangesActivity.itemNow;
        Geofence geofence = LocationActivity.mGeofenceList.get(itemToView);
        EditText itemName = (EditText) findViewById(R.id.item_name);
        itemName.setText(geofence.getRequestId());
    }

}
