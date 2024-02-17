package com.xzcorp.ders2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView mesajDegisken;
    Button buttonDegisken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonDegisken = (Button)findViewById(R.id.kaydet);
        mesajDegisken = (TextView)findViewById(R.id.mesaj);

        buttonDegisken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mesajDegisken.setText("Text Değişti");
            }
        });
        buttonDegisken.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this,"Uzun Bastın",Toast.LENGTH_LONG).show();
                return false;
            }
        });
        buttonDegisken.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                mesajDegisken.setText("Hover");
            }
        });
    }
}