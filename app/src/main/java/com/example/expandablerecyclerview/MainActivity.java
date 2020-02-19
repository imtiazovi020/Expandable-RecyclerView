package com.example.expandablerecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<NameModel> arrayList = new ArrayList<>();

    RecyclerView recyclerview;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerview = findViewById(R.id.recyclerview);

        arrayList.add(new NameModel("Title One","Sub Title One"));
        arrayList.add(new NameModel("Title Two","Sub Title Two"));
        arrayList.add(new NameModel("Title Three","Sub Title Three"));
        arrayList.add(new NameModel("Title Four","Sub Title Four"));

        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerview.setLayoutManager(linearLayoutManager);
        recyclerViewAdapter=new RecyclerViewAdapter(MainActivity.this, arrayList);
        recyclerview.setAdapter(recyclerViewAdapter);

    }
}
