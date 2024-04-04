package com.xzcorp.ders8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button butunDegisken;
    Bundle yardimci;
    WebView webViewDegiskeni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        yardimci=new Bundle();
        yardimci.putString("mesaj","Merhaba Dünya");
        yardimci.putInt("sayisal",100);

        butunDegisken=(Button) findViewById(R.id.gecis);
        butunDegisken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hizmet=new Intent();
                hizmet.setClass(MainActivity.this,Sayfa2.class);
                hizmet.putExtras(yardimci);
                startActivity(hizmet);
            }
        });

        webViewDegiskeni=(WebView) findViewById(R.id.webview);
        webViewDegiskeni.getSettings().setJavaScriptEnabled(true);
        webViewDegiskeni.loadUrl("https://www.google.com");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuObj=getMenuInflater();
        menuObj.inflate(R.menu.optionmenu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.sayfa1){
            Intent i=new Intent("android.intent.action.MAIN");
            startActivity(i);
        }
        else if (item.getItemId()==R.id.sayfa2){
            Intent i=new Intent(MainActivity.this, Sayfa2.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}