package com.example.myapplication.jump;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.R;

public class BActivity extends AppCompatActivity {


    private TextView textView;
    private TextView numberTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        textView = findViewById(R.id.title);
        numberTextView = findViewById(R.id.number);
        Bundle bundle = getIntent().getExtras();
        String title = bundle.getString("name");
        int number = bundle.getInt("number");
        textView.setText(title);
        String number2 =String.valueOf(number);
        numberTextView.setText(number2);
    }
}
