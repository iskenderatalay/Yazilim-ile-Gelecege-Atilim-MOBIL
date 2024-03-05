package com.xzcorp.ders12;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText adText,numaraText,dersText,vizeText,finalText;
    Button kaydetButton;

    FirebaseDatabase veritabani;

    DatabaseReference referans;

    String adSoyad,numaraString,ders,vizeNotString,finalNotString;

    ListView listeDegiskeni;
    List<String> ogrenciler;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adText=(EditText) findViewById(R.id.ad);
        numaraText=(EditText) findViewById(R.id.numara);
        dersText=(EditText) findViewById(R.id.ders);
        vizeText=(EditText) findViewById(R.id.vizeNotu);
        finalText=(EditText) findViewById(R.id.finalNotu);

        kaydetButton=(Button) findViewById(R.id.kaydet);

        veritabani=FirebaseDatabase.getInstance();
        referans=veritabani.getReference("Öğrenciler");

        InputMethodManager inputMethodManager=(InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

        listeDegiskeni=(ListView) findViewById(R.id.liste);

        ogrenciler=new ArrayList<String>();
        arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,ogrenciler);
        listeDegiskeni.setAdapter(arrayAdapter);

        referans.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String map=snapshot.child("Öğrenci adi").getValue(String.class);
                String map2=snapshot.child("Ders").getValue(String.class);
                ogrenciler.add(map+" "+map2);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        kaydetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adSoyad=adText.getText().toString().trim();
                numaraString=numaraText.getText().toString().trim();
                ders=dersText.getText().toString().trim();
                vizeNotString=vizeText.getText().toString().trim();
                finalNotString=finalText.getText().toString().trim();

                if(adSoyad.length()==0||numaraString.length()==0||ders.length()==0||vizeNotString.length()==0||finalNotString.length()==0) {
                    Toast.makeText(MainActivity.this, "Lütfen Boş Değer Girmeyin", Toast.LENGTH_SHORT).show();
                }
                else {
                    DatabaseReference pushId=referans.push();

                    pushId.child("Öğrenci adi").setValue(adSoyad);
                    pushId.child("Öğrenci Numara").setValue(numaraString);
                    pushId.child("Ders").setValue(ders);
                    pushId.child("Vize Notu").setValue(vizeNotString);
                    pushId.child("Final Notu").setValue(finalNotString);

                    Toast.makeText(MainActivity.this,"Kaydedildi",Toast.LENGTH_LONG).show();
                }
                inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(),0);

                adText.setText("");
                numaraText.setText("");
                dersText.setText("");
                vizeText.setText("");
                finalText.setText("");
            }
        });
    }
}