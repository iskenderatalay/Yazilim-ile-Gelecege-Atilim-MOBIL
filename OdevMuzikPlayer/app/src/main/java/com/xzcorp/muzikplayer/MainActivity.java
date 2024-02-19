package com.xzcorp.muzikplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView calanDegisken;
    SeekBar volumeDegisken;
    ListView listeDegisken;
    Button playButonu,stopButonu,pauseButonu;
    MediaPlayer player;
    String sarkilar[]={"Melis Fis-Gülü Sevdim Dikeni Battı","Can Bonomo,Mabel Matiz-Kalbi Hepten Kırıklara","Can Bonomo,Melike Şahin-Tükeniyor Ömrüm","Mabel Matiz-Müphem","Büyük Ev Ablukada-Yangın Akvaryum"};

    int sira;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calanDegisken=(TextView) findViewById(R.id.calan);
        volumeDegisken=(SeekBar) findViewById(R.id.volume);
        listeDegisken=(ListView) findViewById(R.id.liste);
        playButonu=(Button) findViewById(R.id.play);
        pauseButonu=(Button) findViewById(R.id.pause);
        stopButonu=(Button) findViewById(R.id.stop);

        AudioManager sesKontrol=(AudioManager) getSystemService(AUDIO_SERVICE);
        int maxVolume=sesKontrol.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        volumeDegisken.setMax(maxVolume);
        int ses=sesKontrol.getStreamVolume(AudioManager.STREAM_MUSIC);
        volumeDegisken.setProgress(ses);

        volumeDegisken.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sesKontrol.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        listeDegisken.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,sarkilar));
        listeDegisken.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                calanDegisken.setText(listeDegisken.getItemAtPosition(position)+"");
                sira=(int)listeDegisken.getItemIdAtPosition(position);
            }
        });

        playButonu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sira==0) {
                    player = MediaPlayer.create(MainActivity.this, R.raw.ses1);
                    player.start();
                }
                else if (sira==1) {
                    player=MediaPlayer.create(MainActivity.this,R.raw.ses2);
                    player.start();
                }
                else if (sira==2) {
                    player=MediaPlayer.create(MainActivity.this,R.raw.ses3);
                    player.start();
                }
                else if (sira==3) {
                    player=MediaPlayer.create(MainActivity.this,R.raw.ses4);
                    player.start();
                }
                else if (sira==4) {
                    player=MediaPlayer.create(MainActivity.this,R.raw.ses5);
                    player.start();
                }
            }
        });
        pauseButonu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(player.isPlaying())
                    player.pause();
            }
        });
        stopButonu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(player.isPlaying())
                    player.stop();
            }
        });
    }
}