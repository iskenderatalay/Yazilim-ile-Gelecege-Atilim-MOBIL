package com.xzcorp.ders10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button kaydetDegisken,silDegisken,duzeltDegisken;
    EditText not;
    RecyclerView liste;
    ArrayList<Notlar> gelenNotlar=new ArrayList<>();
    String notId=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kaydetDegisken=(Button) findViewById(R.id.kaydet);
        silDegisken=(Button) findViewById(R.id.sil);
        duzeltDegisken=(Button) findViewById(R.id.duzelt);
        not=(EditText) findViewById(R.id.not);
        liste=(RecyclerView) findViewById(R.id.liste);

        listele();

        InputMethodManager inputMethodManager=(InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

        kaydetDegisken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(not.getText().toString().trim().length()!=0) {
                    kaydet();
                    listele();
                    Toast.makeText(MainActivity.this, "Not Kaydedildi", Toast.LENGTH_SHORT).show();
                    not.setText("");
                    inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(),0);
                }
                else
                    Toast.makeText(MainActivity.this, "Lütfen Not Girin", Toast.LENGTH_SHORT).show();
            }
        });

        duzeltDegisken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(not.getText().toString().trim().length()!=0) {
                    duzelt();
                    listele();
                    Toast.makeText(MainActivity.this, "Not Düzeltildi", Toast.LENGTH_SHORT).show();
                    not.setText("");
                    inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(),0);
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
                    not.setText("");
                }
                else
                    Toast.makeText(MainActivity.this, "Not Silinemedi", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void kaydet(){
        DatabaseHelper db=new DatabaseHelper(getApplicationContext());
        db.notEkle(not.getText().toString());
        db.close();
    }

    void listele() {
        DatabaseHelper db=new DatabaseHelper(getApplicationContext());
        gelenNotlar=db.notlariGetir();
        NotAdaptor notadapetorsinif=new NotAdaptor(this,gelenNotlar);
        LinearLayoutManager layoutum=new LinearLayoutManager(getApplicationContext());
        liste.setLayoutManager(layoutum);
        liste.setHasFixedSize(true);
        liste.setAdapter(notadapetorsinif);

        notadapetorsinif.setOnItemClickListener(kendimClickOlusturdum);
        db.close();
    }

    View.OnClickListener kendimClickOlusturdum=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerView.ViewHolder viewHolder=(RecyclerView.ViewHolder) v.getTag();
            int i=viewHolder.getAdapterPosition();
            Notlar item=gelenNotlar.get(i);
            not.setText(item.getNotIcerigi());
            notId=item.getNotId();
        }
    };

    void duzelt(){
        DatabaseHelper db=new DatabaseHelper(getApplicationContext());
        db.notDuzelt(notId,not.getText().toString());
        db.close();
    }

    void sil(){
        DatabaseHelper db=new DatabaseHelper(getApplicationContext());
        db.notSil(notId);
        db.close();
    }
}