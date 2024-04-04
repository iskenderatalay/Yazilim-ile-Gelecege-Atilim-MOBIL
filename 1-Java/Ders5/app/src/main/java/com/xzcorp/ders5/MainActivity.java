package com.xzcorp.ders5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageButton xzcorpDegisken;
    TextView textDegisken;
    float textBoyut=20f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xzcorpDegisken=(ImageButton) findViewById(R.id.xzcorp);
        textDegisken=(TextView) findViewById(R.id.textYaz);
        xzcorpDegisken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"XZCorporation",Toast.LENGTH_LONG).show();
                textDegisken.setText("XZCorporation");
                textBoyut++;
                textDegisken.setTextSize(textBoyut);
            }
        });
    }
}