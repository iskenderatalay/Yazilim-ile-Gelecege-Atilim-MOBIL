package com.xzcorp.odev_hesapmakinasi;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button dokuzDegisken,sekizDegisken,yediDegisken,altiDegisken,besDegisken,dortDegisken,
            ucDegisken,ikiDegisken,birDegisken,sifirDegisken,virgulDegisken,toplaDegisken,cikarDegisken,
            bolDegisken,carpDegisken,esittirDegisken,ceDegisken;

    EditText textDegisken;
    double sayi1,sayi2,sonuc;
    String islem;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dokuzDegisken=(Button) findViewById(R.id.dokuz);
        sekizDegisken=(Button) findViewById(R.id.sekiz);
        yediDegisken=(Button) findViewById(R.id.yedi);
        altiDegisken=(Button) findViewById(R.id.alti);
        besDegisken=(Button) findViewById(R.id.bes);
        dortDegisken=(Button) findViewById(R.id.dort);
        ucDegisken=(Button) findViewById(R.id.uc);
        ikiDegisken=(Button) findViewById(R.id.iki);
        birDegisken=(Button) findViewById(R.id.bir);
        sifirDegisken=(Button) findViewById(R.id.sifir);
        virgulDegisken=(Button) findViewById(R.id.virgul);
        bolDegisken=(Button) findViewById(R.id.bol);
        carpDegisken=(Button) findViewById(R.id.carp);
        cikarDegisken=(Button) findViewById(R.id.cikar);
        toplaDegisken=(Button) findViewById(R.id.topla);
        esittirDegisken=(Button) findViewById(R.id.esittir);
        ceDegisken=(Button) findViewById(R.id.ce);

        textDegisken=(EditText) findViewById(R.id.text);

        dokuzDegisken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textDegisken.setText(textDegisken.getText()+"9");
            }
        });
        sekizDegisken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textDegisken.setText(textDegisken.getText()+"8");
            }
        });
        yediDegisken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textDegisken.setText(textDegisken.getText()+"7");
            }
        });
        altiDegisken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textDegisken.setText(textDegisken.getText()+"6");
            }
        });
        besDegisken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textDegisken.setText(textDegisken.getText()+"5");
            }
        });
        dortDegisken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textDegisken.setText(textDegisken.getText()+"4");
            }
        });
        ucDegisken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textDegisken.setText(textDegisken.getText()+"3");
            }
        });
        ikiDegisken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textDegisken.setText(textDegisken.getText()+"2");
            }
        });
        birDegisken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textDegisken.setText(textDegisken.getText()+"1");
            }
        });
        sifirDegisken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textDegisken.setText(textDegisken.getText()+"0");
            }
        });
        virgulDegisken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textDegisken.setText(textDegisken.getText()+".");
            }
        });
        bolDegisken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayi1=Double.parseDouble(textDegisken.getText().toString());
                islem="bolmeIslemi";
                textDegisken.setText("");
            }
        });
        carpDegisken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayi1=Double.parseDouble(textDegisken.getText().toString());
                islem="carpmaIslemi";
                textDegisken.setText("");
            }
        });
        cikarDegisken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayi1=Double.parseDouble(textDegisken.getText().toString());
                islem="cikarmaIslemi";
                textDegisken.setText("");
            }
        });
        toplaDegisken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayi1=Double.parseDouble(textDegisken.getText().toString());
                islem="toplamaIslemi";
                textDegisken.setText("");
            }
        });
        esittirDegisken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayi2=Double.parseDouble(textDegisken.getText().toString());
                if(sayi2!=0){
                    if(islem.equals("bolmeIslemi"))
                        sonuc=sayi1/sayi2;
                    textDegisken.setText(""+sonuc);
                }
                else
                    textDegisken.setText("Tanımsız İşlem");

                if(islem.equals("carpmaIslemi"))
                    sonuc=sayi1*sayi2;

                if(islem.equals("cikarmaIslemi"))
                    sonuc=sayi1-sayi2;

                if(islem.equals("toplamaIslemi"))
                    sonuc=sayi1+sayi2;

                textDegisken.setText(""+sonuc);
            }
        });
        ceDegisken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textDegisken.setText("");
            }
        });
    }
}