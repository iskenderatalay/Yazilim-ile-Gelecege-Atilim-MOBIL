package com.xzcorp.odevulkemars

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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