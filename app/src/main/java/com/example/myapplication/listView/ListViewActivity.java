package com.example.myapplication.listView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;
import com.example.myapplication.listView.phonebook.PhoneBookActivity;

public class ListViewActivity extends AppCompatActivity {


    private Button mBtnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        mBtnList = findViewById(R.id.btn_listview);
        setListeners();
    }

    private void setListeners() {
        onClick  onClick = new onClick();
        mBtnList.setOnClickListener(onClick);
    }

    private class onClick implements View.OnClickListener {
        Intent intent = null;

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_listview:
                        intent = new Intent(ListViewActivity.this, PhoneBookActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }


}
