package com.hapq.qldc;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class Cn2Activity extends AppCompatActivity implements TruyenHoDan{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cn2);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        //actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1E88E5")));

//        ViewPager pager = (ViewPager) findViewById(R.id.viewpagerCN2);
//        PagerAdapter2 pagerAdapter2 = new PagerAdapter2(getSupportFragmentManager());
//
//        FragmentDiemdanh fragmentDiemdanh = new FragmentDiemdanh();
//        pagerAdapter2.add(fragmentDiemdanh,"THÁNG 1");
//        pagerAdapter2.add(fragmentDiemdanh,"THÁNG 2");
//        pagerAdapter2.add(fragmentDiemdanh,"THÁNG 3");
//
//        pager.setAdapter(pagerAdapter2);
//
//        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);
//        tabLayout.setupWithViewPager(pager);

    }

    @Override
    public void DataFamily(HoGD hoGD) {
        Intent intent = new Intent(Cn2Activity.this, FamilyInforActivity.class);
        intent.putExtra("thongTinGiaDinh", hoGD);
        startActivity(intent);
    }
}