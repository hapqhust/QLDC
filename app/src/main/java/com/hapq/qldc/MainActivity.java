package com.hapq.qldc;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    SinhHoatAdapter adapter;
    ArrayList<Function> CNlist;
    ImageView imgBack;
    String time = "", date = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        Anhxa();
        CNlist = new ArrayList<>();
        adapter = new SinhHoatAdapter(MainActivity.this, R.layout.listview_item_layout, CNlist);
        lv.setAdapter(adapter);
        CNlist.add(new Function(R.drawable.anh1, "Đặt lịch họp", "Thiết lập thời gian sinh hoạt tổ dân phố."));
        CNlist.add(new Function(R.drawable.anh2, "Điểm danh", "Đánh giá sự có mặt của các hộ dân trong các buổi họp."));
        CNlist.add(new Function(R.drawable.anh3, "Gửi thông báo", "Gửi thông báo lịch họp sinh hoạt tổ dân phố tới các chủ hộ dân."));

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Intent intent = new Intent(MainActivity.this, Cn1Activity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("ngay", date);
                    bundle.putString("gio", time);
                    intent.putExtra("dulieu", bundle);
                    startActivity(intent);
                }

                if(position == 1){
                    Intent intent2 = new Intent(MainActivity.this, Cn2Activity.class);
                    startActivity(intent2);
                }
                if(position == 2){
                    if(time!="" && date !=""){
                        Intent intent3 = new Intent(MainActivity.this, Cn3Activity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("ngay", date);
                        bundle.putString("gio", time);
                        intent3.putExtra("dulieu", bundle);
                        startActivity(intent3);
                    }
                    else
                        Toast.makeText(MainActivity.this, "Hãy thực hiện đặt lịch họp trước khi dùng chức năng này", Toast.LENGTH_LONG).show();
                }
            }
        });

        // XỬ LÝ DỮ LIỆU SAU KHI THỰC HIỆN CHỨC NĂNG 1
        Intent intent11 = getIntent();

        Bundle bundle = intent11.getBundleExtra("data");

        if (bundle != null) {
            date = bundle.getString("Date");
            time = bundle.getString("Time");
        }

    }
    private void Anhxa(){
        lv = (ListView) findViewById(R.id.listViewChucNang);
        imgBack = (ImageView) findViewById(R.id.imageViewBack);
    }
}