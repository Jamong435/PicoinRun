package com.auto.picoin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TimePicker timePicker;
    private AlarmManager alarmManager;
    private int hour, minute;

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timePicker = findViewById(R.id.tp_timepicker);
        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


    }// onCreate()..

    public void regist(View view) {

        Intent intent = new Intent(this, AlarmActivity.class);
        PendingIntent pIntent = PendingIntent.getBroadcast(this, 0,intent, 0);
        Toast.makeText(this, "설정되었습니다", Toast.LENGTH_SHORT).show();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            hour=timePicker.getHour();
            minute=timePicker.getMinute();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        // 지정한 시간에 매일 알림
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),  AlarmManager.INTERVAL_DAY, pIntent);

    }// regist()..

    public void unregist(View view) {
        Intent intent = new Intent(this, AlarmActivity.class);
        PendingIntent pIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
        Toast.makeText(this, "해지되었습니다", Toast.LENGTH_SHORT).show();
        alarmManager.cancel(pIntent);
    }// unregist()..


}// MainActivity class..

