package com.xzcorp.ders13;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText adText,numaraText,dersText,vizeText,finalText;
    Button kaydetButton,yukleButton,indirButton;
    String adSoyad,numaraString,ders,vizeNotString,finalNotString;
    ListView listeDegiskeni;
    List<String> ogrenciler;
    ArrayAdapter<String> arrayAdapter;
    FirebaseDatabase veritabani;
    DatabaseReference referans,dataReferansi;
    StorageReference dosyalama;
    ProgressBar beklemeNesnesi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adText=(EditText)findViewById(R.id.ad);
        numaraText=(EditText)findViewById(R.id.numara);
        dersText=(EditText)findViewById(R.id.ders);
        vizeText=(EditText)findViewById(R.id.vizeNotu);
        finalText=(EditText)findViewById(R.id.finalNotu);

        kaydetButton=(Button)findViewById(R.id.kaydet);
        yukleButton=(Button)findViewById(R.id.yukle);
        indirButton=(Button)findViewById(R.id.indir);

        listeDegiskeni=(ListView)findViewById(R.id.liste);

        veritabani=FirebaseDatabase.getInstance();

        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

        beklemeNesnesi=(ProgressBar)findViewById(R.id.progressBar);

        ogrenciler=new ArrayList<String>();
        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ogrenciler);
        listeDegiskeni.setAdapter(arrayAdapter);

        FirebaseApp.initializeApp(this);

        dosyalama=FirebaseStorage.getInstance().getReference();

        dataReferansi=veritabani.getReference("data");

        dataReferansi.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String gelenVeri = snapshot.getValue().toString();
                Toast.makeText(MainActivity.this, gelenVeri, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        referans=veritabani.getReference("Öğrenciler");
        Query queryObj=referans.orderByChild("Final Notu").limitToFirst(3);

        queryObj.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String isim=snapshot.child("Öğrenci adi").getValue(String.class);
                String ders=snapshot.child("Ders").getValue(String.class);
                String notu=snapshot.child("Final Notu").getValue(String.class);
                ogrenciler.add(isim+" "+ders+" "+notu);
                arrayAdapter.notifyDataSetChanged();
            }
            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
            }
            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
            }
            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        kaydetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adSoyad = adText.getText().toString().trim();
                numaraString = numaraText.getText().toString().trim();
                ders = dersText.getText().toString().trim();
                vizeNotString = vizeText.getText().toString().trim();
                finalNotString = finalText.getText().toString().trim();

                if (adSoyad.isEmpty() || numaraString.isEmpty() || ders.isEmpty() || vizeNotString.isEmpty() || finalNotString.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Lütfen Boş Değer Girmeyin", Toast.LENGTH_SHORT).show();
                } else {
                    DatabaseReference pushId = referans.push();

                    pushId.child("Öğrenci adi").setValue(adSoyad);
                    pushId.child("Öğrenci Numara").setValue(numaraString);
                    pushId.child("Ders").setValue(ders);
                    pushId.child("Vize Notu").setValue(vizeNotString);
                    pushId.child("Final Notu").setValue(finalNotString);

                    Toast.makeText(MainActivity.this, "Kaydedildi", Toast.LENGTH_LONG).show();
                }

                inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(), 0);

                adText.setText("");
                numaraText.setText("");
                dersText.setText("");
                vizeText.setText("");
                finalText.setText("");
            }
        });

        yukleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galeriAc=new Intent(Intent.ACTION_PICK);
                galeriAc.setType("image/*");
                someActivityResultLauncher.launch(galeriAc);
            }
        });

        indirButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadImage("xztek2023.png");
            }
        });

        beklemeNesnesi.setVisibility(View.INVISIBLE);
    }

    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode()==Activity.RESULT_OK) {
                //Toast.makeText(MainActivity.this, "Resim Seçiniz", Toast.LENGTH_LONG).show();
                beklemeNesnesi.setVisibility(View.VISIBLE);

                Intent data=result.getData();

                Uri alinanResim=data.getData();
                String resimAdi=getFileName(alinanResim);

                StorageReference filePath=dosyalama.child("resimler").child(resimAdi);

                filePath.putFile(alinanResim).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Toast.makeText(MainActivity.this, "Resim Yüklendi", Toast.LENGTH_SHORT).show();
                        beklemeNesnesi.setVisibility(View.INVISIBLE);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
            else if (result.getResultCode()==Activity.RESULT_CANCELED) {
                Toast.makeText(MainActivity.this, "Resim Seçmediniz", Toast.LENGTH_LONG).show();
            }
        }
    });

    void downloadImage(String imageName){
        String indirilecekYol= Environment.getExternalStorageDirectory()+ File.separator+"Download/";
        File indirileekYoldakiKlasor=new File(indirilecekYol);
        if(!indirileekYoldakiKlasor.exists())
            indirileekYoldakiKlasor.mkdirs();
        String indirilecekResim=indirilecekYol+imageName+".png";
        File indirilecekResimDosyasi=new File(indirilecekResim);
        if(!indirilecekResimDosyasi.exists()){
            StorageReference firebasedekiDosyaYolu=dosyalama.child("resimler/"+imageName);
            Uri resimUrisi=Uri.fromFile(indirilecekResimDosyasi);
            firebasedekiDosyaYolu.getFile(resimUrisi).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    Toast.makeText(MainActivity.this, "Resim İndi", Toast.LENGTH_LONG).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this, "Resim İnmedi", Toast.LENGTH_LONG).show();
                }
            });
        }
    }
    public String getFileName(Uri uri) {
        String result = null;
        if (uri.getScheme().equals("content")) {
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                }
            } finally {
                cursor.close();
            }
        }
        if (result == null) {
            result = uri.getPath();
            int cut = result.lastIndexOf('/');
            if (cut != -1) {
                result = result.substring(cut + 1);
            }
        }
        return result;
    }
}