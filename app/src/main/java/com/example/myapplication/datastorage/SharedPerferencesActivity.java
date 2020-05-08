package com.example.myapplication.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

public class SharedPerferencesActivity extends AppCompatActivity {

    private Button mBtnSave;

    private Button mBtnShow;

    private TextView mTextView;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor meditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_perferences);
        mBtnSave = findViewById(R.id.btn_save);
        mBtnShow = findViewById(R.id.btn_show);
        mTextView = findViewById(R.id.et_name);
        sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        meditor = sharedPreferences.edit();
        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                meditor.putString("name", mTextView.getText().toString());
                meditor.apply();
            }
        });
        mBtnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText(sharedPreferences.getString("name", ""));
            }
        });
    }
}
