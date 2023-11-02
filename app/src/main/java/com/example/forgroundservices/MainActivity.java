package com.example.forgroundservices;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity{
    private Button startServiceButton;
    private Button stopServiceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startServiceButton = findViewById(R.id.startServiceButton);
        stopServiceButton = findViewById(R.id.stopServiceButton);

        startServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent serviceIntent = new Intent(MainActivity.this, ServicesMedia.class);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    startForegroundService(serviceIntent);
                }
                startServiceButton.setVisibility(View.GONE);
                stopServiceButton.setVisibility(View.VISIBLE);
            }
        });

        stopServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent serviceIntent = new Intent(MainActivity.this,ServicesMedia.class);
                stopService(serviceIntent);
                startServiceButton.setVisibility(View.VISIBLE);
                stopServiceButton.setVisibility(View.GONE);

//                if(startServiceButton.getVisibility()==View.VISIBLE){
//                    stopServiceButton.setVisibility(View.GONE);
//                }else if(stopServiceButton.getVisibility()==View.VISIBLE) {
//                    startServiceButton.setVisibility(View.GONE);
//                }
            }
        });
    }
}
