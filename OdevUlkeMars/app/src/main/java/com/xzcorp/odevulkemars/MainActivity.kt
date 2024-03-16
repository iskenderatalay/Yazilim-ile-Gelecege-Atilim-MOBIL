package com.xzcorp.odevulkemars

import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import java.io.File

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager=LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter=Adapter(getModels())

        downloadMp3("azerbaycan.mp3")
        downloadMp3("belcika.mp3")
        downloadMp3("dijibouti.mp3")
        downloadMp3("ispanya.mp3")
        downloadMp3("turkiye.mp3")
        downloadMp3("japonya.mp3")
        downloadMp3("cin.mp3")
        downloadMp3("yunanistan.mp3")
        downloadMp3("ingiltere.mp3")
        downloadMp3("amerika.mp3")
        downloadMp3("uruguay.mp3")
    }

    fun downloadMp3(mp3Name: String){
        val indirilecekYol = Environment.getExternalStorageDirectory().toString() + File.separator + "Download/"
        val indirilecekYoldakiKlasor = File(indirilecekYol)
        if (!indirilecekYoldakiKlasor.exists())
            indirilecekYoldakiKlasor.mkdirs()
        val indirilecekMp3 = indirilecekYol+mp3Name
        val indirilecekMp3Dosyasi = File(indirilecekMp3)

        if(!indirilecekMp3Dosyasi.exists()){
            var storage = Firebase.storage.getReference().child("/"+mp3Name)
            val mp3Urisi = Uri.fromFile(indirilecekMp3Dosyasi)

            storage.getFile(mp3Urisi).addOnSuccessListener {
                Toast.makeText(this,"Mp3 İndi",Toast.LENGTH_LONG).show()
            }.addOnFailureListener {
                Toast.makeText(this, "Mp3 İnmedi", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun getModels():MutableList<CountryModel>{
        val models=mutableListOf(CountryModel(R.drawable.azerbaycan,"Azerbaycan","Bakü", "azerbaycan.mp3"),
            CountryModel(R.drawable.belcika,"Belçika","Brüksel","belcika.mp3"),
            CountryModel(R.drawable.dijibouti,"Dijibouti","Dijibouti","dijibouti.mp3"),
            CountryModel(R.drawable.ispanya,"İspanya","Madrid","ispanya.mp3"),
            CountryModel(R.drawable.turkiye,"Türkiye","Ankara","turkiye.mp3"),
            CountryModel(R.drawable.japan,"Japonya","Tokyo","japonya.mp3"),
            CountryModel(R.drawable.china,"Çin","Pekin","cin.mp3"),
            CountryModel(R.drawable.greece,"Yunanistan","Atina","yunanistan.mp3"),
            CountryModel(R.drawable.uk,"İngiltere","London","ingiltere.mp3"),
            CountryModel(R.drawable.abd,"Amerika","Washington, DC","amerika.mp3"),
            CountryModel(R.drawable.uruguay,"Uruguay","Montevideo","uruguay.mp3"))
        return models
    }
}