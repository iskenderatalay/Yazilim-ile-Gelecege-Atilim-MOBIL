package com.xzcorp.butonyakalama;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView geriSayDegisken,rastSayiDegisken,skorDegisken;
    int[] idList={R.id.bug1,R.id.bug2,R.id.bug3,R.id.bug4,R.id.bug5,R.id.bug6,R.id.bug7,R.id.bug8,R.id.bug9,
            R.id.bug10,R.id.bug11,R.id.bug12,R.id.bug13,R.id.bug14,R.id.bug15,R.id.bug16};
    ImageButton[] bugList=new ImageButton[idList.length];
    int skor=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        geriSayDegisken=(TextView) findViewById(R.id.geriSay);
        rastSayiDegisken=(TextView) findViewById(R.id.rastSay);
        skorDegisken=(TextView) findViewById(R.id.skor);

        for(int i=0;i<idList.length;i++){
            bugList[i]=(ImageButton)findViewById(idList[i]);
            bugList[i].setVisibility(View.INVISIBLE);
        }

        Handler delay=new Handler();
        Random rasUret=new Random();

        CountDownTimer gerisayim = new CountDownTimer(60000,2000) {
            @Override
            public void onTick(long millisUntilFinished) {
                geriSayDegisken.setText("GeriSayim= "+millisUntilFinished/1000);
                int rasUretSayi=rasUret.nextInt(16);
                rastSayiDegisken.setText("RasgeleSayi= "+rasUretSayi);

                switch (rasUretSayi){
                    case 0:
                        bugList[0].setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        bugList[1].setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        bugList[2].setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        bugList[3].setVisibility(View.VISIBLE);
                        break;
                    case 4:
                        bugList[4].setVisibility(View.VISIBLE);
                        break;
                    case 5:
                        bugList[5].setVisibility(View.VISIBLE);
                        break;
                    case 6:
                        bugList[6].setVisibility(View.VISIBLE);
                        break;
                    case 7:
                        bugList[7].setVisibility(View.VISIBLE);
                        break;
                    case 8:
                        bugList[8].setVisibility(View.VISIBLE);
                        break;
                    case 9:
                        bugList[9].setVisibility(View.VISIBLE);
                        break;
                    case 10:
                        bugList[10].setVisibility(View.VISIBLE);
                        break;
                    case 11:
                        bugList[11].setVisibility(View.VISIBLE);
                        break;
                    case 12:
                        bugList[12].setVisibility(View.VISIBLE);
                        break;
                    case 13:
                        bugList[13].setVisibility(View.VISIBLE);
                        break;
                    case 14:
                        bugList[14].setVisibility(View.VISIBLE);
                        break;
                    case 15:
                        bugList[15].setVisibility(View.VISIBLE);
                        break;
                    default:
                        break;
                }
                delay.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for(int i=0;i<idList.length;i++){
                            bugList[i].setVisibility(View.INVISIBLE);
                        }
                    }
                }, 600);
            }
            @Override
            public void onFinish() {
                geriSayDegisken.setText("Süre Bitti");
            }
        }.start();
        for(int i=0;i<idList.length;i++){
            bugList[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    skor+=1;
                    skorDegisken.setText("Skor= "+skor);
                }
            });
        }
    }
}