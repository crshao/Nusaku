package com.example.nusaku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.nusaku.authentication.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Login extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.masuk)
    Button b1;
    @BindView(R.id.back)
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @OnClick(R.id.masuk)
    void masuk(){
        startActivity(new Intent(this , MainActivity.class));
    }

    @OnClick(R.id.back)
    void back(){
        startActivity(new Intent(this , Welcome.class));
    }

    @Override
    public void onClick(View v) {

    }
}

