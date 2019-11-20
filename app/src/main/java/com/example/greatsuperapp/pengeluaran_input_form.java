package com.example.greatsuperapp;
import android.database.Cursor;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class pengeluaran_input_form extends AppCompatActivity {
    protected Cursor cursor;
    DatabaseHelper dbHelper;
    Button btnsimpan;
    EditText textfaktor, texttgl, textjumlah, textketerangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengeluaran_input_form);

        dbHelper = new DatabaseHelper(this);
        textfaktor = (EditText) findViewById(R.id.inputfaktorpengeluaran);
        texttgl = (EditText) findViewById(R.id.inputtanggalpengeluaran);
        textjumlah = (EditText) findViewById(R.id.inputjumlahpengeluaran);
        textketerangan = (EditText) findViewById(R.id.inputketeranganpengeluaran);
        btnsimpan = (Button) findViewById(R.id.btnsimpanpengeluaran);

        btnsimpan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into pengeluaran(no,factor,tanggal,jumlah,keterangan) values('" +
                        textfaktor.getText().toString() + "','"+
                        texttgl.getText().toString() + "','"+
                        textjumlah.getText().toString() + "','"+
                        textketerangan.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                finish();
            }
        });


    }
}
