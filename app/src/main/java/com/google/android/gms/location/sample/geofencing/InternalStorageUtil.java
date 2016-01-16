package com.google.android.gms.location.sample.geofencing;


import android.content.Context;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Persists the user entered locations to a file on user exists and read back from the file and load
 * to the system on start.
 */
public class InternalStorageUtil {
    public static final String FILE_NAME = "locations.txt";

    protected static synchronized void writeToFile(List<String> geofences, Context context) {

        String geofencesList = "";
        for (String geofence : geofences) {
            geofencesList = geofencesList + geofence + "\n\r";
        }

        for (String file : context.fileList()) {
            if (file.equals(FILE_NAME)) {
                Map<String, LocationEntry> existingEntries = readFromFile(context);
                for (String location : existingEntries.keySet()) {
                    LocationEntry localtionEntry = existingEntries.get(location);
                    geofencesList = geofencesList + location + ":" + localtionEntry.description + ":" +
                            localtionEntry.activeTime + ":" + localtionEntry.getLatLng().latitude + ":" +
                            localtionEntry.getLatLng().longitude + "\n\r";
                }
                break;

            }
        }
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                    context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE));
            outputStreamWriter.write(geofencesList);
            outputStreamWriter.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    protected static synchronized Map<String, LocationEntry> readFromFile(Context context) {

        Map<String, LocationEntry> storedLocations = new HashMap<String, LocationEntry>();

        try {
            InputStream inputStream = context.openFileInput(FILE_NAME);

            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";

                while ((receiveString = bufferedReader.readLine()) != null && !receiveString.trim().isEmpty()) {
                    String[] locations = receiveString.split(":");
                    LocationEntry locationEntry = new LocationEntry(
                            new LatLng(Double.parseDouble(locations[3]), Double.parseDouble(locations[4])),
                            locations[0], Integer.parseInt(locations[2]), locations[1]);
                    storedLocations.put(locations[0], locationEntry);
                }

                inputStream.close();
            }
        } catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }
        return storedLocations;
    }

}
