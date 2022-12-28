package com.example.third_assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<DataModel> dataSet;
    private LinearLayoutManager layoutManager;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycleVieCon);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        dataSet = new ArrayList<DataModel>();
        for (int i = 0; i < MyData.id_.length; i++) {
            dataSet.add(new DataModel(MyData.nameArray[i], MyData.versionArray[i],
                    MyData.id_[i], MyData.drawableArray[i]));
        }
        adapter = new CustomAdapter(dataSet);
        recyclerView.setAdapter(adapter);
    }
}