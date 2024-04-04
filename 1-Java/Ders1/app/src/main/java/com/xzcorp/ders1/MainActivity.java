package com.xzcorp.ders1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button buttonDegiskeni;
    TextView mesajDegiskeni;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonDegiskeni = (Button)findViewById(R.id.kaydetButonu);
        mesajDegiskeni = (TextView)findViewById(R.id.mesaj);

        buttonDegiskeni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mesajDegiskeni.setText("Merhaba Dünya :)");
                Toast.makeText(MainActivity.this,"Android Eğitimleri",Toast.LENGTH_LONG).show();
            }
        });
    }
}