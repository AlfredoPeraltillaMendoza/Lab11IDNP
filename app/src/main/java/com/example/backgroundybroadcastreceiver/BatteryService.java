package com.example.backgroundybroadcastreceiver;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class BatteryService extends Service {

    private BatteryLowReceiver batteryLowReceiver;

    @Override
    public void onCreate() {
        super.onCreate();
        batteryLowReceiver = new BatteryLowReceiver();
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_LOW);
        registerReceiver(batteryLowReceiver, filter);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(batteryLowReceiver);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}