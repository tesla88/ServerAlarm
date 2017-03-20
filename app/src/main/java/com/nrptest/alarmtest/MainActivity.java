package com.nrptest.alarmtest;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {


    String TAG ="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    @Override
    protected void onStart() {
        super.onStart();

//        initAlarm();
        initServerAlarm();
    }

    void initAlarm()
    {
        Intent intent = new Intent(MainActivity.this, AlarmReceiver.class);
        final PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 100, intent, 0);

        final AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 5000, pendingIntent);
    }

    ServerAlarm mAlarm = new ServerAlarm();
    void initServerAlarm()
    {
        Log.d(TAG, "initServerAlarm: ");
        mAlarm.setAlarm(this);
    }
}
