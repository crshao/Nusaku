package com.example.nusaku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Register extends BaseActivity {
    @BindView(R.id.daftar)
    Button b1;
    @BindView(R.id.back)
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    @OnClick(R.id.daftar)
    void daftar(){
        startActivity(new Intent(this , Welcome.class));
    }

    @OnClick(R.id.back)
    void back(){
        startActivity(new Intent(this , Welcome.class));
    }
}