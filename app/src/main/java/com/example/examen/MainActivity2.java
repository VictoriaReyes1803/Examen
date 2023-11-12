package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("name");
            String description = intent.getStringExtra("description");
            String edad = intent.getStringExtra("edad");
            TextView nameTextView = findViewById(R.id.name);
            TextView edadTextView = findViewById(R.id.edad);
            TextView descriptionTextView = findViewById(R.id.description);

            nameTextView.setText(name);
            edadTextView.setText(edad);
            descriptionTextView.setText(description);
        }
    }
}