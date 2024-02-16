package com.xzcorp.ders3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.TaskStackBuilder;

public class ikinciSayfa extends AppCompatActivity {
    Button uceGitDegisken;
    TextView ikinciSayfaTextViewDegisken;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ikincisayfa);

        ikinciSayfaTextViewDegisken = (TextView)findViewById(R.id.ikinciSayfaTextView);

        Intent hizmet=getIntent();
        String gelenText=hizmet.getStringExtra("gidenText");
        int gelenSayi=hizmet.getIntExtra("gidenSayi",100);

        ikinciSayfaTextViewDegisken.setText(gelenText + " " + gelenSayi);

        uceGitDegisken=(Button)findViewById(R.id.uceGec);
        uceGitDegisken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                Intent geri = new Intent(ikinciSayfa.this,MainActivity.class);
                startActivity(geri);
                */
                /*
                Intent geri=new Intent();
                geri.setClass(ikinciSayfa.this, MainActivity.class);
                startActivity(geri);
                */
                Intent uc = new Intent();
                uc.setClass(ikinciSayfa.this, ucuncuSayfa.class);
                startActivity(uc);
            }
        });
    }
}