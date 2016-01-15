package com.google.android.gms.location.sample.geofencing;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by amila on 7/17/15.
 */
public class LocationEntry {

    LatLng latLng;
    String name;
    Integer activeTime;
    String description;

    public LocationEntry(LatLng latLng, String name, Integer activeTime, String description) {
        this.latLng = latLng;
        this.name = name;
        this.activeTime = activeTime;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
