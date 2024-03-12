package com.xzcorp.odevpiano;

import android.media.SoundPool;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    int[] idList={R.id.w1,R.id.b1,R.id.w2,R.id.b2,R.id.w3,R.id.w4,R.id.b3,R.id.w5,R.id.b4,R.id.w6,R.id.b5,
            R.id.w7,R.id.w8,R.id.b6,R.id.w9,R.id.b7,R.id.w10,R.id.w11,R.id.b8,R.id.w12,R.id.b9,R.id.w13,
            R.id.b10,R.id.w14};
    int[] rawList={R.raw.t1,R.raw.t2,R.raw.t3,R.raw.t4,R.raw.t5,R.raw.t6,R.raw.t7,R.raw.t8,R.raw.t9,
            R.raw.t10,R.raw.t11,R.raw.t12,R.raw.t13,R.raw.t14,R.raw.t15,R.raw.t6,R.raw.t17,R.raw.t18,
            R.raw.t19,R.raw.t20,R.raw.t21,R.raw.t22,R.raw.t23,R.raw.t24};
    View[] buttonList=new View[idList.length];

    SoundPool soundPool;
    int[] soundList=new int[24];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        for(int i=0;i<idList.length;i++){
            buttonList[i]=(View) findViewById(idList[i]);
        }

        soundPool = new SoundPool.Builder().setMaxStreams(24).build();
        for(int i=0;i<soundList.length;i++){
            soundList[i]= soundPool.load(this, rawList[i], 1);
        }

        buttonList[0].setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                soundPool.play(soundList[0], 1, 1, 0, 0, 1);
                return false;
            }
        });
        buttonList[1].setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                soundPool.play(soundList[1], 1, 1, 0, 0, 1);
                return false;
            }
        });
        buttonList[2].setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                soundPool.play(soundList[2], 1, 1, 0, 0, 1);
                return false;
            }
        });
        buttonList[3].setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                soundPool.play(soundList[3], 1, 1, 0, 0, 1);
                return false;
            }
        });
        buttonList[4].setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                soundPool.play(soundList[4], 1, 1, 0, 0, 1);
                return false;
            }
        });
        buttonList[5].setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                soundPool.play(soundList[5], 1, 1, 0, 0, 1);
                return false;
            }
        });
        buttonList[6].setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                soundPool.play(soundList[6], 1, 1, 0, 0, 1);
                return false;
            }
        });
        buttonList[7].setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                soundPool.play(soundList[7], 1, 1, 0, 0, 1);
                return false;
            }
        });
        buttonList[8].setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                soundPool.play(soundList[8], 1, 1, 0, 0, 1);
                return false;
            }
        });
        buttonList[9].setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                soundPool.play(soundList[9], 1, 1, 0, 0, 1);
                return false;
            }
        });
        buttonList[10].setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                soundPool.play(soundList[10], 1, 1, 0, 0, 1);
                return false;
            }
        });
        buttonList[11].setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                soundPool.play(soundList[11], 1, 1, 0, 0, 1);
                return false;
            }
        });
        buttonList[12].setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                soundPool.play(soundList[12], 1, 1, 0, 0, 1);
                return false;
            }
        });
        buttonList[13].setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                soundPool.play(soundList[13], 1, 1, 0, 0, 1);
                return false;
            }
        });
        buttonList[14].setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                soundPool.play(soundList[14], 1, 1, 0, 0, 1);
                return false;
            }
        });
        buttonList[15].setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                soundPool.play(soundList[15], 1, 1, 0, 0, 1);
                return false;
            }
        });
        buttonList[16].setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                soundPool.play(soundList[16], 1, 1, 0, 0, 1);
                return false;
            }
        });
        buttonList[17].setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                soundPool.play(soundList[17], 1, 1, 0, 0, 1);
                return false;
            }
        });
        buttonList[18].setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                soundPool.play(soundList[18], 1, 1, 0, 0, 1);
                return false;
            }
        });
        buttonList[19].setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                soundPool.play(soundList[19], 1, 1, 0, 0, 1);
                return false;
            }
        });
        buttonList[20].setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                soundPool.play(soundList[20], 1, 1, 0, 0, 1);
                return false;
            }
        });
        buttonList[21].setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                soundPool.play(soundList[21], 1, 1, 0, 0, 1);
                return false;
            }
        });
        buttonList[22].setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                soundPool.play(soundList[22], 1, 1, 0, 0, 1);
                return false;
            }
        });
        buttonList[23].setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                soundPool.play(soundList[23], 1, 1, 0, 0, 1);
                return false;
            }
        });
    }
}