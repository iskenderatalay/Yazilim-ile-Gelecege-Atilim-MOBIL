package com.xzcorp.ders11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText adSoyadText;
    Button kaydet;
    String adSoyad;

    FirebaseDatabase veritabani;
    DatabaseReference referans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adSoyadText=(EditText) findViewById(R.id.adSoyadText);
        kaydet=(Button) findViewById(R.id.kaydet);

        veritabani=FirebaseDatabase.getInstance();
        //referans=veritabani.getReference("adSoyad");//firebasedeki adSoyad
        //referans=veritabani.getReference("okul2");//firebasede okul2yi olusturur sonra icine yazar
        //referans=veritabani.getReference();//firebasede rastgele anahtar olusturup yapar
        referans=veritabani.getReference("mesajlar").child("detaylar");

        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adSoyad=adSoyadText.getText().toString().trim();
                if(adSoyadText.length()==0)
                    Toast.makeText(MainActivity.this, "Lütfen Boş Değer Girmeyin", Toast.LENGTH_SHORT).show();
                else{
                    //firebase kaydet
                    //referans.setValue(adSoyad);
                    referans.push().setValue(adSoyad);//alt child olusturur
                }
            }
        });
    }
}