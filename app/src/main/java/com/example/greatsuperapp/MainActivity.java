package com.example.greatsuperapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.app.Activity;

public class MainActivity extends AppCompatActivity {

    Button BtnPendapatan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnPendapatan = findViewById(R.id.btnpendapatan);

        BtnPendapatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, pendapatan_input_form.class));
            }
        });
    }
}