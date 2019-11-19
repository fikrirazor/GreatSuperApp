package com.example.greatsuperapp;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.Toast;

public class pendapatan_input_form extends AppCompatActivity {
    protected Cursor cursor;
    DatabaseHelper dbHelper;
    Button btnok;
    EditText textfactor, texttgl, textjumlah, textketerangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendapatan_input_form);

        dbHelper = new DatabaseHelper(this);
        textfactor = (EditText) findViewById(R.id.InputFaktor);
        texttgl = (EditText) findViewById(R.id.InputTanggal);
        textjumlah = (EditText) findViewById(R.id.InputJumlah);
        textketerangan = (EditText) findViewById(R.id.InputKeterangan);
        btnok = (Button) findViewById(R.id.btnTambahPendapatan);

        btnok.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into pendapatan(no,factor,tanggal,jumlah,ketarangan) values('" +
                        textfactor.getText().toString() + "','"+
                        texttgl.getText().toString() + "','"+
                        textjumlah.getText().toString() + "','"+
                        textketerangan.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
