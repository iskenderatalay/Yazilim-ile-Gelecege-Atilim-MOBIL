package com.xzcorp.ders3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ucuncuSayfa extends AppCompatActivity {
    Button bireGitDegisken;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ucuncusayfa);

        bireGitDegisken = (Button)findViewById(R.id.bireGit);
        bireGitDegisken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bireGitmelisin=new Intent();
                bireGitmelisin.setClass(ucuncuSayfa.this, MainActivity.class);
                startActivity(bireGitmelisin);
            }
        });
    }
}
