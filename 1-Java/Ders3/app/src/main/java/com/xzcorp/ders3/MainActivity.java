package com.xzcorp.ders3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText kullanicidanVeriAlanDegisken;
    Button gecisDegisken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kullanicidanVeriAlanDegisken=(EditText)findViewById(R.id.kullanicidanVeriAlan);
        gecisDegisken=(Button)findViewById(R.id.gecis);

        gecisDegisken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                Intent hizmet = new Intent("android.intent.action.IKINCI");
                startActivity(hizmet);
                */
                /*
                Intent hizmet = new Intent(MainActivity.this, ikinciSayfa.class);
                startActivity(hizmet);
                */
                Intent hizmet=new Intent();
                hizmet.setClass(MainActivity.this,ikinciSayfa.class);

                //hizmet.putExtra("gidenText","Merhaba Dünya");
                hizmet.putExtra("gidenText",kullanicidanVeriAlanDegisken.getText().toString());
                hizmet.putExtra("gidenSayi",123);
                startActivity(hizmet);
            }
        });

        kullanicidanVeriAlanDegisken.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

    }
}