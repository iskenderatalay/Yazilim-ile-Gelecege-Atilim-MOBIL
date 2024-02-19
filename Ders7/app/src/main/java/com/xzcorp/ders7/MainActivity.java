package com.xzcorp.ders7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView sonucDegiskeni;
    SeekBar degerDegiskeni;

    ListView listeDegiskeni;
    String sarkilar[]={"Şarkı1","Şarkı2","Şarkı3","Şarkı4","Şarkı5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sonucDegiskeni=(TextView) findViewById(R.id.sonuc);
        degerDegiskeni=(SeekBar) findViewById(R.id.deger);

        listeDegiskeni=(ListView) findViewById(R.id.liste);
        listeDegiskeni.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,sarkilar));

        listeDegiskeni.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sonucDegiskeni.setText(listeDegiskeni.getItemAtPosition(position)+"");

            }
        });

        //degerDegiskeni.setProgress(30);

        degerDegiskeni.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sonucDegiskeni.setText(progress+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        /*
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
           @Override
           public void handleOnBackPressed() {
               AlertDialog.Builder alertNesnesi=new AlertDialog.Builder(MainActivity.this);
               alertNesnesi.setTitle("Uyarı");
               alertNesnesi.setMessage("Çıkacak mısın?");
               alertNesnesi.setCancelable(true);

               alertNesnesi.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       finish();
                   }
               });

               alertNesnesi.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       Toast.makeText(MainActivity.this, "Teşekkür", Toast.LENGTH_SHORT).show();
                   }
               });
               AlertDialog dialog=alertNesnesi.create();
               dialog.show();
           }
       });
         */
    }
}