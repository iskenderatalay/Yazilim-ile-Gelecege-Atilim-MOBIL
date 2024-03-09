package com.xzcorp.ders14;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    FirebaseFirestore db;
    TextView gelenDataDegiskeni;

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

        db=FirebaseFirestore.getInstance();
        gelenDataDegiskeni=(TextView)findViewById(R.id.gelenData);

        Map<String, Object> personel = new HashMap<>();
        personel.put("adi", "hüseyin");
        personel.put("soyadi", "bodur");
        personel.put("uyruk", "T.C");
        personel.put("kimlikNo", 12345);
        personel.put("dogumTarihi", "22.12.1890");

        db.collection("personeller").document("personel1").set(personel).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d("TAG", "DocumentSnapshot successfully written!");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w("TAG",e.toString(), e);
            }
        });

        //rasgele document id oluşturur
        db.collection("personeller").add(personel).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Log.d("TAG", "DocumentSnapshot successfully written!");
            }
        });

        //dilersek bir sınıf oluşturup bu sınıfın değerlerini koleksiyon olarak
        //kaydedebiliriz.
        City city = new City("Los Angeles", "CA", "USA",false, 5000000L, Arrays.asList("west_coast", "sorcal"));
        db.collection("cities").document("LA").set(city);

        //firestore den veri okuma
        DocumentReference docRef = db.collection("personeller").document("personel1");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        gelenDataDegiskeni.setText(document.getData().toString());
                        Log.d("TAG", "DocumentSnapshot data: " + document.getData());
                        Toast.makeText(MainActivity.this,"oldu",Toast.LENGTH_LONG).show();
                    }
                    else {
                        Log.d("TAG", "No such document");
                        Toast.makeText(MainActivity.this,"dokuman yok",Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Log.d("TAG", "get failed with ", task.getException());
                    Toast.makeText(MainActivity.this,task.getException().toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}