package com.xzcorp.ders9;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText telefonNumarasiDegisken,mesajDegisken;
    TextView textDegisken;
    Button aramaYapDegisken,smsGonderDegisken;
    SeekBar mesajSayisiDegisken;
    String numara,mesajIcerik;
    Intent aramaIntenti;
    int sayac=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textDegisken=(TextView) findViewById(R.id.text);
        telefonNumarasiDegisken=(EditText) findViewById(R.id.telefonNumarasi);
        mesajDegisken=(EditText) findViewById(R.id.mesaj);
        aramaYapDegisken=(Button) findViewById(R.id.aramaYap);
        smsGonderDegisken=(Button) findViewById(R.id.smsGonder);
        mesajSayisiDegisken=(SeekBar) findViewById(R.id.mesajSayisi);

        aramaIntenti=new Intent(Intent.ACTION_CALL);

        mesajSayisiDegisken.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sayac=progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        aramaYapDegisken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numara=telefonNumarasiDegisken.getText().toString().trim(); //yazıda boşluklar varsa temizler
                if(numara.length()==0){
                    //uyarı
                    Toast.makeText(MainActivity.this,"Lütfen No Girin",Toast.LENGTH_LONG).show();
                } else if (numara.length()!=11) {
                    Toast.makeText(MainActivity.this,"Numarayı Doğru Gir",Toast.LENGTH_LONG).show();
                } else{
                    //arama yap
                    aramaIntenti.setData(Uri.parse("tel:"+numara));
                        startActivity(aramaIntenti);
                }
            }
        });
        smsGonderDegisken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numara=telefonNumarasiDegisken.getText().toString().trim(); //yazıda boşluklar varsa temizler
                mesajIcerik=mesajDegisken.getText().toString().trim();
                if(numara.length()==0 || mesajIcerik.length()==0){
                    //uyarı
                    Toast.makeText(MainActivity.this,"Lütfen Tüm Alanları Doldurun",Toast.LENGTH_LONG).show();
                } else if (numara.length()!=11) {
                    Toast.makeText(MainActivity.this,"Numarayı Doğru Gir",Toast.LENGTH_LONG).show();
                } else{
                    //mesaj at
                    Intent hizmet=new Intent(getApplicationContext(),MainActivity.class);
                    PendingIntent pi=PendingIntent.getActivity(getApplicationContext(),0,hizmet, PendingIntent.FLAG_IMMUTABLE);

                    SmsManager smsManager=SmsManager.getDefault();

                    for(int i=0;i<sayac;i++)   {
                        smsManager.sendTextMessage(numara,null,mesajIcerik,pi,null);
                    }

                    mesajDegisken.setText("");
                    telefonNumarasiDegisken.setText("");
                }
            }
        });
    }
}