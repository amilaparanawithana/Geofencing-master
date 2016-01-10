package com.google.android.gms.location.sample.geofencing;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by amila on 7/17/15.
 */
public class LocationEntry {

    LatLng latLng;
    String name;
    Integer activeTime;

    public LocationEntry(LatLng latLng, String name, Integer activeTime) {
        this.latLng = latLng;
        this.name = name;
        this.activeTime = activeTime;
    }


    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Integer activeTime) {
        this.activeTime = activeTime;
    }
}
