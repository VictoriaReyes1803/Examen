package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Maindetail {
    TextView Name;
    TextView phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);


        List<item_view> items = new ArrayList<>();
        items.add(new item_view("Vicky", "la conoci bailando", "20 anos", "0909090909"));
        items.add(new item_view("Oswaldo", "En el trabajo", "23 anos", "0909090909"));
        items.add(new item_view("Linda", "En el trabajo", "30 anos", "0909090909"));
        items.add(new item_view("Ramiro", "En el trabajo", "30 anos", "0909090909"));
        items.add(new item_view("Luna", "En el trabajo", "23 anos", "0909090909"));


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter = new MyAdapter((Context) this, items, (Maindetail) this);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onItemClick(item_view item) {
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("name", item.getName());
        intent.putExtra("description", item.getDescription());
        intent.putExtra("edad", item.getEdad());
        intent.putExtra("phone", item.getPhone());
        startActivity(intent);
    }
}