package com.xzcorp.ders4;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    TextView textDegiskeni;
    MediaPlayer sesDosyasi;
    Button startDegiskeni, pauseDegiskeni;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //textDegiskeni=(TextView) findViewById(R.id.mesaj);
        Toast.makeText(MainActivity.this,"on Create a girdi",Toast.LENGTH_SHORT).show();

        sesDosyasi=MediaPlayer.create(MainActivity.this,R.raw.tom);
        //sesDosyasi.start();

        startDegiskeni=(Button) findViewById(R.id.start);
        pauseDegiskeni=(Button) findViewById(R.id.pause);

        startDegiskeni.setVisibility(View.VISIBLE);
        pauseDegiskeni.setVisibility(View.INVISIBLE);

        startDegiskeni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!sesDosyasi.isPlaying())
                    sesDosyasi.start();
                startDegiskeni.setVisibility(View.INVISIBLE);
                pauseDegiskeni.setVisibility(View.VISIBLE);
            }
        });
        pauseDegiskeni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sesDosyasi.isPlaying())
                    sesDosyasi.pause();
                pauseDegiskeni.setVisibility(View.INVISIBLE);
                startDegiskeni.setVisibility(View.VISIBLE);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(MainActivity.this,"on START a girdi",Toast.LENGTH_SHORT).show();
        //sesDosyasi.start();
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(MainActivity.this,"on STOP a girdi",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(MainActivity.this,"on DESTROY a girdi",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(MainActivity.this,"on PAUSE a girdi",Toast.LENGTH_SHORT).show();
        //sesDosyasi.stop();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(MainActivity.this,"on RESUME a girdi",Toast.LENGTH_SHORT).show();
    }
}