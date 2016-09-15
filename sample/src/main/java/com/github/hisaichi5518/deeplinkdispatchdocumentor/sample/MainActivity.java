package com.github.hisaichi5518.deeplinkdispatchdocumentor.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.airbnb.deeplinkdispatch.DeepLink;

@DeepLink({"yuriko-app://yoshitaka/yuriko/{id}", "yuriko-app://yositaka/yuriko/{id}"})
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
