package com.example.nusaku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class Welcome extends AppCompatActivity {
    @BindView(R.id.masuk)
    Button b1;
    @BindView(R.id.daftar)
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ViewPager viewPager = findViewById(R.id.viewPager);
        ImageAdapter adapter = new ImageAdapter(this);
        viewPager.setAdapter(adapter);

        ButterKnife.bind(this);
    }
    @OnClick(R.id.masuk)
    void masuk(){
        startActivity(new Intent(this , Login.class));
    }

    @OnClick(R.id.daftar)
    void daftar(){
        startActivity(new Intent(this , Register.class));
    }

}
