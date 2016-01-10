/**
 * Copyright 2014 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.gms.location.sample.geofencing;

import com.google.android.gms.maps.model.LatLng;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Constants used in this sample.
 */
public final class Constants {

    private Constants() {
    }

    public static final String PACKAGE_NAME = "com.google.android.gms.location.Geofence";

    public static final String SHARED_PREFERENCES_NAME = PACKAGE_NAME + ".SHARED_PREFERENCES_NAME";

    public static final String GEOFENCES_ADDED_KEY = PACKAGE_NAME + ".GEOFENCES_ADDED_KEY";

    public static final String filename = "GeoFile";

    /**
     * Used to set an expiration time for a geofence. After this amount of time Location Services
     * stops tracking the geofence.
     */
    public static final long GEOFENCE_EXPIRATION_IN_HOURS = 48;

    /**
     * For this sample, geofences expire after twelve hours.
     */
    public static final long GEOFENCE_EXPIRATION_IN_MILLISECONDS =
            GEOFENCE_EXPIRATION_IN_HOURS * 60 * 60 * 1000;
    public static final float GEOFENCE_RADIUS_IN_METERS = 5000; // 1 mile, 1.6 km
    public static final int LOITERING_DELAY = 6000;

    /**
     * Map for storing information about landmarks.
     */
    public static final HashMap<String, LatLng> MY_LANDMARKS = new HashMap<String, LatLng>();
    static {


        // Wso2 Kollupitiya.
        MY_LANDMARKS.put("WSO2", new LatLng(6.909947, 79.852246));

        // Public Library.
        MY_LANDMARKS.put("Library", new LatLng(6.912745, 79.858870));

        //Amila Home
        MY_LANDMARKS.put("Amila Home", new LatLng( 6.7967605, 79.8992293));

        //Malabe
        MY_LANDMARKS.put("Malabe", new LatLng(6.903983, 79.955003));

        //My Bording
        MY_LANDMARKS.put("Boarding", new LatLng( 6.919181, 79.860577));

        //Gampaha Station
        MY_LANDMARKS.put("Gampaha Railway", new LatLng( 7.093527, 79.993698));

        //My Homw
        MY_LANDMARKS.put("Push Home", new LatLng( 7.046655,80.128387));

        MY_LANDMARKS.put("CSE", new LatLng( 6.796928, 79.900432));
        MY_LANDMARKS.put("CSE2", new LatLng( 6.797019, 79.899906));


        ;

    }
}
