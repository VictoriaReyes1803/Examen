package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Inicio extends AppCompatActivity {
    TextView Contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Contador = findViewById(R.id.Contador);

        long duration = 5 * 1000;
        long interval = 1000;

        new CountDownTimer(duration, interval) {
            @Override
            public void onTick(long millisUntilFinished) {
                long secondsRemaining = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished);
                String sDuration = String.format(Locale.ENGLISH, "%02d %02d",
                        secondsRemaining / 60, secondsRemaining % 60);
                Contador.setText(sDuration);
            }

            @Override
            public void onFinish() {
                Contador.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(),
                        "Countdown timer has ended", Toast.LENGTH_LONG).show();
                requestPermissions(new String[]{android.Manifest.permission.CALL_PHONE}, 1987);
                Intent intent = new Intent(Inicio.this, MainActivity.class);
                startActivity(intent);

    }
        }.start();


    }

}