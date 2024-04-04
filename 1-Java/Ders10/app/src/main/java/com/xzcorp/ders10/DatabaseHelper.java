package com.xzcorp.ders10;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String veritabaniAdi="ders10.db";
    private static int veritabaniVersiyon=1;
    static final String tabloAdi="notlar";
    static final String kolonId="notId";
    static final String kolonAdi="notIcerik";

    static final String TabloOlusturSql="CREATE TABLE "+tabloAdi+ " ("+kolonId+" INTEGER PRIMARY KEY AUTOINCREMENT, "+kolonAdi+" TEXT )";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TabloOlusturSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+tabloAdi);
        onCreate(db);
    }

    DatabaseHelper(Context context){
        super(context,veritabaniAdi,null,veritabaniVersiyon);
    }

    void notEkle(String not){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(kolonAdi,not);

        long sonuc=db.insert(tabloAdi,null,cv);
        if(sonuc>-1)
            Log.i("kayit","Not basariyla kaydedildi");
        else
            Log.i("kayit","Not basariyla kaydedilmedi");
        db.close();
    }

    void notDuzelt(String notId,String notIcerik){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(kolonAdi,notIcerik);
        db.update(tabloAdi,cv,kolonId+"=?", new String[]{notId});
        db.close();
    }

    void notSil(String notId){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(tabloAdi,kolonId+"=?",new String[]{notId});
        db.close();
    }

    ArrayList<Notlar> notlariGetir(){
        ArrayList<Notlar> data=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        String[] gelecekKolonlar={kolonId,kolonAdi};
        Cursor c=db.query(tabloAdi,gelecekKolonlar,null,null,null,null,null);

        while(c.moveToNext()){
            data.add(new Notlar(c.getString(c.getColumnIndex(kolonId)),c.getString(c.getColumnIndex(kolonAdi) )));
        }
        c.close();
        db.close();
        return data;
    }
}