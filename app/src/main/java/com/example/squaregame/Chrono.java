package com.example.squaregame;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;

public class Chrono extends Service {

    private Handler handler;
    private Runnable runnable;
    private long startTime;
    private long elapsedTime;
    public Chrono() {
    }
    @Override
    public void onCreate() {
        super.onCreate();
        handler = new Handler();
        startTime = SystemClock.elapsedRealtime();
        runnable = new Runnable() {
            @Override
            public void run() {
                elapsedTime = SystemClock.elapsedRealtime() - startTime;
                broadcastElapsedTime();

                handler.postDelayed(this, 1000); // Met à jour toutes les secondes
            }
        };
        handler.post(runnable);
    }
    private void broadcastElapsedTime() {
        Intent intent = new Intent("chrono-tick");
        intent.putExtra("elapsedTime", elapsedTime);
        sendBroadcast(intent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }
}