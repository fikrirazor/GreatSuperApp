package com.example.greatsuperapp;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "tes.db";
    private static final int DATABASE_VERSION = 1;
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table pendapatan(no integer primary key, factor text null, tanggal text null, jumlah integer null, keterangan text null);";
        Log.d("Data","onCreate: " + sql);
        db.execSQL(sql);
        String sql2 = "create table pengeluaran(no integer primary key, factor text null, tanggal text null, jumlah integer null, keterangan text null);";
        Log.d("Data","onCreate: " + sql2);
        db.execSQL(sql2);
        sql = "INSERT INTO pendapatan(no,factor,tanggal,jumlah,keterangan) VALUES ('1','tes','2019-11-19','12','oke tes');";
        db.execSQL(sql);
        sql2 = "INSERT INTO pengeluaran(no,factor,tanggal,jumlah,keterangan) VALUES ('1','tes','2019-11-19','12','oke tes');";
        db.execSQL(sql2);
    }
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // Todo Auto-generated method stub
    }
}