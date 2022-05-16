package com.hapq.qldc;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Cn1Activity extends AppCompatActivity {

    ViewPager pager;
    TextView txtDate, txtTime;
    Button btnHuy, btnCF;
    String date, time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cn1);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        pager = (ViewPager) findViewById(R.id.viewpagerCN1);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());

        //FragmentManager fragmentManager = getFragmentManager();
        FragmentDateCN1 fragmentDateCN1 = new FragmentDateCN1();
        pagerAdapter.add(fragmentDateCN1);
        FragmentTimeCN1 fragmentTimeCN1 = new FragmentTimeCN1();
        pagerAdapter.add(fragmentTimeCN1);

        pager.setAdapter(pagerAdapter);

        Anhxa();
        Intent intent11 = getIntent();
        Bundle bundleM = intent11.getBundleExtra("dulieu");
        if (bundleM != null) {
            date = bundleM.getString("ngay");
            time = bundleM.getString("gio");
        }
        txtDate.setText(date);
        txtTime.setText(time);

         btnCF.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 date = txtDate.getText().toString();
                 time = txtTime.getText().toString();
                 Intent intent = new Intent(Cn1Activity.this, MainActivity.class);
                 Bundle bundle = new Bundle();
                 bundle.putString("Date", date);
                 bundle.putString("Time", time);
                 intent.putExtra("data", bundle);
                 startActivity(intent);
             }
         });
         btnHuy.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 txtDate.setText(date);
                 txtTime.setText(time);
             }
         });

    }
    private void Anhxa(){
        txtDate = (TextView) findViewById(R.id.textDateNumber);
        txtTime = (TextView) findViewById(R.id.textTimeNumber);
        btnHuy = (Button) findViewById(R.id.buttonCancel);
        btnCF = (Button) findViewById(R.id.buttonConfirm);
    }

}