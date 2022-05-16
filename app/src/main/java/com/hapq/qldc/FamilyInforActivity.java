package com.hapq.qldc;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;

public class FamilyInforActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_infor);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Intent intent = getIntent();
        HoGD giadinh = (HoGD) intent.getSerializableExtra("thongTinGiaDinh");

        FragmentGDInfor fragmentGDInfor = (FragmentGDInfor) getSupportFragmentManager().findFragmentById(R.id.fragmentGdInfor);
        fragmentGDInfor.SetInfor(giadinh);
    }
}