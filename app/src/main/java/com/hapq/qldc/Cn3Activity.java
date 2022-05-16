package com.hapq.qldc;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Cn3Activity extends AppCompatActivity {

    String date, time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cn3);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        Intent intent = getIntent();
        Bundle bundleM = intent.getBundleExtra("dulieu");
        if (bundleM != null) {
            date = bundleM.getString("ngay");
            time = bundleM.getString("gio");
        }
        FragmentChuHo fragmentChuHo = (FragmentChuHo) getSupportFragmentManager().findFragmentById(R.id.fragment);
        fragmentChuHo.date = date;
        fragmentChuHo.time = time;
    }
}