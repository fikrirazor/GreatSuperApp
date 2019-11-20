package com.example.greatsuperapp;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class laporan_view_form extends AppCompatActivity {
    protected Cursor cursor;
    DatabaseHelper dbHelper;
    TextView textpendapatan,textpengeluaran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporan_view_form);

        dbHelper = new DatabaseHelper(this);
        textpendapatan = (TextView) findViewById(R.id.textView2);
        textpengeluaran = (TextView) findViewById(R.id.textView7);
        textpendapatan.setText(Integer.toString(jumlahpendapatan()));
        textpengeluaran.setText(Integer.toString(jumlahpengeluaran()));

    }

    public int jumlahpendapatan(){
        int total = 0;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT SUM(jumlah) FROM pendapatan", null);
        if(c.moveToFirst()){
            total = c.getInt(0);
        }
        return total;
    }

    public int jumlahpengeluaran(){
        int total = 0;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT SUM(jumlah) FROM pengeluaran", null);
        if(c.moveToFirst()){
            total = c.getInt(0);
        }
        return total;
    }
}
