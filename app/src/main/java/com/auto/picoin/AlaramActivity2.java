package com.auto.picoin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AlaramActivity2 extends AppCompatActivity {
    private Intent intent;
    private final String packageNames = "com.blockchainvault";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alaram2);

        intent = this.getPackageManager().getLaunchIntentForPackage(packageNames);
    }

    public void clickbtninstart(View view) {
        AlaramActivity2.this.startActivity(intent);
    }
}