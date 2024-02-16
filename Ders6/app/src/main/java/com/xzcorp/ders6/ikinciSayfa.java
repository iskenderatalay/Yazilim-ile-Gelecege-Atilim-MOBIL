package com.xzcorp.ders6;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ikinciSayfa extends AppCompatActivity {
    RadioGroup radyolar;
    RadioButton bestfm,kralfm,alemfm,superfm;
    TextView secimSonuc;
    Button secimKontrolDegiskeni;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ikincisayfa);

        radyolar=(RadioGroup) findViewById(R.id.radyolar);
        bestfm=(RadioButton) findViewById(R.id.bestfm);
        kralfm=(RadioButton) findViewById(R.id.kralfm);
        alemfm=(RadioButton) findViewById(R.id.alemfm);
        superfm=(RadioButton) findViewById(R.id.superfm);
        secimSonuc=(TextView) findViewById(R.id.secimSonuc);

        secimKontrolDegiskeni=(Button) findViewById(R.id.secimKontrol);

        secimKontrolDegiskeni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int secilenRadyo=radyolar.getCheckedRadioButtonId();

                if(secilenRadyo==R.id.bestfm)
                    secimSonuc.setText("BestFm desin");
                else if(secilenRadyo==R.id.alemfm)
                    secimSonuc.setText("AlemFm desin");
                else if(secilenRadyo==R.id.superfm)
                    secimSonuc.setText("SuperFm desin");
                else if(secilenRadyo==R.id.kralfm)
                    secimSonuc.setText("KralFm desin");
            }
        });
    }
}
