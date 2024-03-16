package com.xzcorp.ders17

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        recyclerView=findViewById(R.id.recyclerView)
        recyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter=Adapter(getModels())
    }

    fun getModels():MutableList<CountryModel>{
        val models=mutableListOf(CountryModel(R.drawable.azerbeycan,"Azerbeycan","Bakü"),
            CountryModel(R.drawable.belcika,"Belçika","Brüksel"),
            CountryModel(R.drawable.dijibouti,"Dijibouti","Dijibouti"),
            CountryModel(R.drawable.ispanya,"İspanya","Madrid"),
            CountryModel(R.drawable.turkiye,"Türkiye","Ankara"),
            CountryModel(R.drawable.japan,"Japonya","Tokyo"),
            CountryModel(R.drawable.china,"Çin","Pekin"),
            CountryModel(R.drawable.greece,"Yunanistan","Atina"),
            CountryModel(R.drawable.uk,"İngiltere","London"),
            CountryModel(R.drawable.abd,"Amerika","Washington, DC"),
            CountryModel(R.drawable.uruguay,"Uruguay","Montevideo"))

        return models
    }
}