package com.hapq.qldc;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText edtUser, edtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        Anhxa();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chuoi1 = edtUser.getText().toString();
                String chuoi2 = edtPassword.getText().toString();
                //kiem tra chuoi rong
                if(chuoi1.equals("admin") && chuoi2.equals("1")){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(LoginActivity.this, "Bạn đã đăng nhập thành công", Toast.LENGTH_LONG).show();
                }else
                    Toast.makeText(LoginActivity.this, "Tên đăng nhập hoặc mật khẩu chưa chính xác", Toast.LENGTH_LONG).show();
            }
        });
    }
    private void Anhxa(){
        btnLogin = (Button) findViewById(R.id.buttonLogin);
        edtUser = (EditText) findViewById(R.id.editUsers);
        edtPassword = (EditText) findViewById(R.id.editPassWord);
    }
}