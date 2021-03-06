package com.auto.picoin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class AlaramActivity2 extends AppCompatActivity {
    private Intent intent;
    private final String packageNames = "com.blockchainvault";

    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alaram2);

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        

        intent = this.getPackageManager().getLaunchIntentForPackage(packageNames);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    public void clickbtninstart(View view) {
        AlaramActivity2.this.startActivity(intent);
    }

    public void clickbtn(View view) {
        Intent intent2 = new Intent(this,MainActivity.class);
        startActivity(intent2);
    }
}
