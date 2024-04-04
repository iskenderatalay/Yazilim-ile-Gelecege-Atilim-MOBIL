package com.xzcorp.ders8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class Sayfa2 extends AppCompatActivity {

    TextView gosterText;
    ImageView imageViewNesnesi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sayfa2);

        gosterText=findViewById(R.id.goster);

        /*
        try{
            Bundle karsila=getIntent().getExtras();
            String gelenMesaj=karsila.getString("mesaj");
            int gelenSayi=karsila.getInt("sayisal")  ;

            gosterText.setText(gelenMesaj+" "+gelenSayi);
        }
        catch (Exception e){}
         */

        imageViewNesnesi=(ImageView) findViewById(R.id.imageView);
        // imageViewNesnesi.setImageResource(R.drawable.cicek);

        String path=Environment.getExternalStorageDirectory()+"/Images/Pictures/IMG_20240205_120919.jpg";
        File dosya=new File(path);
        if(dosya.exists()){
            Bitmap bitmapFormati=BitmapFactory.decodeFile(dosya.getAbsolutePath());
            imageViewNesnesi.setImageBitmap(bitmapFormati);
        }
        gosterText.setText(path);


    }
}