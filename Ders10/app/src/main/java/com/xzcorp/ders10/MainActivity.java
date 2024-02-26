package com.xzcorp.ders10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button kaydetDegisken,silDegisken,duzeltDegisken;
    EditText notDegisken;
    RecyclerView listeDegisken;

    String notId=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kaydetDegisken=(Button) findViewById(R.id.kaydet);
        silDegisken=(Button) findViewById(R.id.sil);
        duzeltDegisken=(Button) findViewById(R.id.duzelt);
        notDegisken=(EditText) findViewById(R.id.not);
        listeDegisken=(RecyclerView) findViewById(R.id.liste);

        kaydetDegisken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(notDegisken.getText().toString().trim().length()!=0){
                    kaydet();
                    listele();
                    Toast.makeText(MainActivity.this, "Not Kaydedildi", Toast.LENGTH_SHORT).show();
                    notId="1";
                }
                else
                    Toast.makeText(MainActivity.this, "Lütfen Not Girin", Toast.LENGTH_SHORT).show();
            }
        });

        duzeltDegisken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(notDegisken.getText().toString().trim().length()!=0){
                    duzelt();
                    listele();
                    Toast.makeText(MainActivity.this, "Not Düzeltildi", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(MainActivity.this, "Lütfen Boş Bırakmayın", Toast.LENGTH_SHORT).show();
            }
        });

        silDegisken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(notId!=""){
                    sil();
                    listele();
                    Toast.makeText(MainActivity.this, "Not Silindi", Toast.LENGTH_SHORT).show();
                    notId="";
                }
                else
                    Toast.makeText(MainActivity.this, "Not Silinemedi", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void kaydet(){
        DatabaseHelper db=new DatabaseHelper(getApplicationContext());
        db.notEkle(notDegisken.getText().toString());
        db.close();
    }

    void listele(){
        //Şimdilik boş
    }

    void duzelt(){
        DatabaseHelper db=new DatabaseHelper(getApplicationContext());
        db.notDuzelt(notId,notDegisken.getText().toString());
        db.close();
    }

    void sil(){
        DatabaseHelper db=new DatabaseHelper(getApplicationContext());
        db.notSil(notId);
        db.close();
    }
}