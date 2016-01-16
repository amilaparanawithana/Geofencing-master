/*
 * Copyright 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.gms.location.sample.geofencing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.location.Geofence;
import com.google.android.gms.maps.model.LatLng;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//import android.support.v4.app.NavUtils;


/**
 * This sample demonstrates how to use system-provided, automatic layout transitions. Layout
 * transitions are animations that occur when views are added to, removed from, or changed within
 * a {@link android.view.ViewGroup}.
 * <p/>
 * <p>In this sample, the user can add rows to and remove rows from a vertical
 * {@link android.widget.LinearLayout}.</p>
 */
public class LayoutChangesActivity extends Activity {
    /**
     * The container view which has layout change animations turned on. In this sample, this view
     * is a {@link android.widget.LinearLayout}.
     */
    private ViewGroup mContainerView;
    public static int itemNow=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_changes);

        mContainerView = (ViewGroup) findViewById(R.id.container);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.activity_layout_changes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // Navigate "up" the demo structure to the launchpad activity.
                // See http://developer.android.com/design/patterns/navigation.html for more.
//                NavUtils.navigateUpTo(this, new Intent(this, MainActivity.class));
                return true;

            case R.id.action_add_item:
                // Hide the "empty" view since there is now at least one item in the list.
                findViewById(android.R.id.empty).setVisibility(View.GONE);
                addItem();
                return true;
            case R.id.action_menu_list:
                // Hide the "empty" view since there is now at least one item in the list.
//                findViewById(android.R.id.empty).setVisibility(View.GONE);
                addMenuItemList();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void addItem() {

        Sample[] mSamples;

        mSamples = new Sample[]{
                new Sample(R.string.action_edit_item, LocationActivity.class),
        };
        startActivity(new Intent(LayoutChangesActivity.this, mSamples[0].activityClass));

    }

    private void addMenuItemList() {
        // Instantiate a new "row" view.

        ArrayList<Geofence> geofenceList;
        if(LocationActivity.mGeofenceList == null){
            geofenceList = populateGeofenceList();
        } else {
            geofenceList = LocationActivity.mGeofenceList;
        }

        mContainerView.removeAllViews();
        if(geofenceList!=null){
            for (int i = 0; i < geofenceList.size(); i++) {
                final ViewGroup newView = (ViewGroup) LayoutInflater.from(this).inflate(
                        R.layout.all_list_entries, mContainerView, false);

                ((TextView) newView.findViewById(android.R.id.text1)).setText(
                        geofenceList.get(i).getRequestId());

                itemNow = i;
                mContainerView.addView(newView, 0);

                newView.findViewById(R.id.edit_button).setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Sample[] mSamples;
                                mSamples = new Sample[]{
                                        new Sample(R.string.action_edit_item, EditItemActivity.class),
                                };

                                startActivity(new Intent(LayoutChangesActivity.this, mSamples[0].activityClass));

                            }
                        }

                );
            }
        }
    }

    private class Sample {
        private CharSequence title;
        private Class<? extends Activity> activityClass;

        public Sample(int titleResId, Class<? extends Activity> activityClass) {
            this.activityClass = activityClass;
            this.title = getResources().getString(titleResId);
        }

        @Override
        public String toString() {
            return title.toString();
        }
    }

    public ArrayList<Geofence> populateGeofenceList() {

        ArrayList<Geofence> initialList  = new ArrayList<Geofence>();

        for (Map.Entry<String, LatLng> entry : Constants.MY_LANDMARKS.entrySet()) {

            initialList.add(new Geofence.Builder()
                    // Set the request ID of the geofence. This is a string to identify this
                    // geofence.
                    .setRequestId(entry.getKey())

                            // Set the circular region of this geofence.
                    .setCircularRegion(
                            entry.getValue().latitude,
                            entry.getValue().longitude,
                            Constants.GEOFENCE_RADIUS_IN_METERS
                    )

                            // Set the expiration duration of the geofence. This geofence gets automatically
                            // removed after this period of time.
                    .setExpirationDuration(Constants.GEOFENCE_EXPIRATION_IN_MILLISECONDS)

                            // Set the transition types of interest. Alerts are only generated for these
                            // transition. We track entry and exit transitions in this sample.
                    .setTransitionTypes(Geofence.GEOFENCE_TRANSITION_DWELL | Geofence.GEOFENCE_TRANSITION_ENTER |
                            Geofence.GEOFENCE_TRANSITION_EXIT)

                    .setLoiteringDelay(Constants.LOITERING_DELAY)

                            // Create the geofence.
                    .build());
        }

        return initialList;
    }


}
