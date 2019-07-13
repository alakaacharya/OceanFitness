package com.alaka.oceanapp.services;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.alaka.oceanapp.R;

public class MyService extends Service implements LocationListener {

    private boolean isNotificationShown = false;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onCreate() {
        LocationManager manager = (LocationManager) getSystemService(LOCATION_SERVICE);
        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 0, this);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onLocationChanged(Location location) {
        Location gymLocation = new Location("");
        gymLocation.setLatitude(27.70);
        gymLocation.setLongitude(85.33);

        if (location.distanceTo(gymLocation) < 200) {
            if (isNotificationShown) return;
            isNotificationShown = true;
            showNotification("Near to Gym", "Nearly there");
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void showNotification(String title, String desc) {
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            CharSequence name = "Channel1";
            String description = "This is channel 1";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("Channel1", name, importance);
            channel.setDescription(description);
            notificationManager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "Channel1")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(title)
                .setContentText(desc)
                .setStyle(new NotificationCompat.BigTextStyle())
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        notificationManager.notify(1, builder.build());

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
