package com.example.myapplication.recycleView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.R;

public class GridRecyclearViewActivity extends AppCompatActivity {

    private RecyclerView mRvGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recyclear_view);
        mRvGrid = findViewById(R.id.rv_grid);
        mRvGrid.setLayoutManager(new GridLayoutManager(GridRecyclearViewActivity.this, 3));
        mRvGrid.setAdapter(new GridAdapter(GridRecyclearViewActivity.this, new GridAdapter.OnItemClickListener() {
            @Override
                public void onClick(int pos) {
                Toast.makeText(GridRecyclearViewActivity.this, "click......" + pos, Toast.LENGTH_SHORT).show();
            }
        }));
    }
}
