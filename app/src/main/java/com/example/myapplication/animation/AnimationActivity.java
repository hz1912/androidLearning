package com.example.myapplication.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

import com.example.myapplication.R;

public class AnimationActivity extends AppCompatActivity {

    private Button mBtnanimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        mBtnanimation = findViewById(R.id.btn_animation);
        mBtnanimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //起始x轴，最终x轴，起始y轴，最终y轴
                TranslateAnimation translateAnimation = new TranslateAnimation(0, 80, 0, 80);
                mBtnanimation.setAnimation(translateAnimation);
            }
        });

    }
}
