package com.xzcorp.odevcufcuf;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    ImageButton cuf;
    StorageReference dosyalama;
    MediaPlayer sesDosyasi;

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

        cuf=(ImageButton)findViewById(R.id.button);

        FirebaseApp.initializeApp(this);
        dosyalama=FirebaseStorage.getInstance().getReference();

        downloadMp3("cufcuf.mp3");
        String path=Environment.getExternalStorageDirectory().getPath()+"/Download/cufcuf.mp3";
        sesDosyasi=MediaPlayer.create(MainActivity.this, Uri.parse(path));

        cuf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sesDosyasi.start();
            }
        });
        cuf.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                sesDosyasi.stop();
                return false;
            }
        });
    }
    void downloadMp3(String mp3Name){
        String indirilecekYol=Environment.getExternalStorageDirectory()+ File.separator+"Download/";
        File indirileekYoldakiKlasor=new File(indirilecekYol);
        if(!indirileekYoldakiKlasor.exists())
            indirileekYoldakiKlasor.mkdirs();
        String indirilecekMp3=indirilecekYol+mp3Name;
        File indirilecekMp3Dosyasi=new File(indirilecekMp3);

        if(!indirilecekMp3Dosyasi.exists()){
            StorageReference firebasedekiDosyaYolu=dosyalama.child("/"+mp3Name);
            Uri mp3Urisi=Uri.fromFile(indirilecekMp3Dosyasi);
            firebasedekiDosyaYolu.getFile(mp3Urisi).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    Toast.makeText(MainActivity.this, "Mp3 İndi", Toast.LENGTH_LONG).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this, "Mp3 İnmedi", Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}