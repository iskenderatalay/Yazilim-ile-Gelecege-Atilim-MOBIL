package com.xzcorp.ders6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {

    CheckBox makarnaDegiskeni,kebapDegiskeni,iskenderDegiskeni,pilavDegiskeni,fasulyeDegiskeni;
    Button yemeklerButonDegiskeni,nextDegiskeni;
    TextView sonucDegiskeni;
    String sonuclar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        makarnaDegiskeni=(CheckBox) findViewById(R.id.makarna);
        kebapDegiskeni=(CheckBox) findViewById(R.id.kebap);
        iskenderDegiskeni=(CheckBox) findViewById(R.id.iskender);
        pilavDegiskeni=(CheckBox) findViewById(R.id.pilav);
        fasulyeDegiskeni=(CheckBox) findViewById(R.id.fasulye);

        yemeklerButonDegiskeni=(Button) findViewById(R.id.yemeklerButon);
        nextDegiskeni=(Button) findViewById(R.id.next);

        sonucDegiskeni=(TextView) findViewById(R.id.sonuc);

        yemeklerButonDegiskeni.setEnabled(false);

        nextDegiskeni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hizmet=new Intent();
                hizmet.setClass(MainActivity.this, ikinciSayfa.class);
                startActivity(hizmet);
            }
        });

        yemeklerButonDegiskeni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sonuclar="";
                if(makarnaDegiskeni.isChecked())
                    sonuclar+="Makarna ";
                if(kebapDegiskeni.isChecked())
                    sonuclar+="Kebap ";
                if(iskenderDegiskeni.isChecked())
                    sonuclar+="İskender ";
                if(pilavDegiskeni.isChecked())
                    sonuclar+="Pilav ";
                if(fasulyeDegiskeni.isChecked())
                    sonuclar+="Taze Fasulye ";
                sonucDegiskeni.setText(sonuclar+"Seviyorsun");
            }
        });
        makarnaDegiskeni.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(makarnaDegiskeni.isChecked()){
                    yemeklerButonDegiskeni.setEnabled(true);
                    Toast.makeText(MainActivity.this, "Seçildi", Toast.LENGTH_SHORT).show();
                }
                else{
                    yemeklerButonDegiskeni.setEnabled(false);
                    Toast.makeText(MainActivity.this, "Seçili Değil", Toast.LENGTH_SHORT).show();
                }
            }
        });
        kebapDegiskeni.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(kebapDegiskeni.isChecked()){
                    yemeklerButonDegiskeni.setEnabled(true);
                    Toast.makeText(MainActivity.this, "Seçildi", Toast.LENGTH_SHORT).show();
                }
                else{
                    yemeklerButonDegiskeni.setEnabled(false);
                    Toast.makeText(MainActivity.this, "Seçili Değil", Toast.LENGTH_SHORT).show();
                }
            }
        });
        iskenderDegiskeni.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(iskenderDegiskeni.isChecked()){
                    yemeklerButonDegiskeni.setEnabled(true);
                    Toast.makeText(MainActivity.this, "Seçildi", Toast.LENGTH_SHORT).show();
                }
                else{
                    yemeklerButonDegiskeni.setEnabled(false);
                    Toast.makeText(MainActivity.this, "Seçili Değil", Toast.LENGTH_SHORT).show();
                }
            }
        });
        pilavDegiskeni.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(pilavDegiskeni.isChecked()){
                    yemeklerButonDegiskeni.setEnabled(true);
                    Toast.makeText(MainActivity.this, "Seçildi", Toast.LENGTH_SHORT).show();
                }
                else{
                    yemeklerButonDegiskeni.setEnabled(false);
                    Toast.makeText(MainActivity.this, "Seçili Değil", Toast.LENGTH_SHORT).show();
                }
            }
        });
        fasulyeDegiskeni.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(fasulyeDegiskeni.isChecked()){
                    yemeklerButonDegiskeni.setEnabled(true);
                    Toast.makeText(MainActivity.this, "Seçildi", Toast.LENGTH_SHORT).show();
                }
                else{
                    yemeklerButonDegiskeni.setEnabled(false);
                    Toast.makeText(MainActivity.this, "Seçili Değil", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}