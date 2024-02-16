package com.xzcorp.odev_butontiklanincarenkdegisimi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button odevButonDegisken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] renkListesiDizisi=getResources().getIntArray(R.array.renkListesi);

        odevButonDegisken=(Button) findViewById(R.id.buttonOdev);
        odevButonDegisken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rastgeleRenkler = renkListesiDizisi[new Random().nextInt(renkListesiDizisi.length)];
                odevButonDegisken.setBackgroundColor(rastgeleRenkler);
            }
        });
    }
}