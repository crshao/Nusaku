package com.example.nusaku;

//import android.os.Bundle;
//import android.support.wearable.activity.WearableActivity;
//import android.widget.TextView;
//
//public class Welcome extends WearableActivity {
//
//    private TextView mTextView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_welcome);
//
//        mTextView = (TextView) findViewById(R.id.text);
//
//        // Enables Always-on
//        setAmbientEnabled();
//    }
//}
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class Welcome extends AppCompatActivity {
//    @BindView(R.id.now)
//    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ViewPager viewPager = findViewById(R.id.viewPager);
        ImageAdapter adapter = new ImageAdapter(this);
        viewPager.setAdapter(adapter);

        ButterKnife.bind(this);
    }
//    @OnClick(R.id.now)
//    void mlg(){
//        startActivity(new Intent(this , Donate_K.class));
//    }

}
