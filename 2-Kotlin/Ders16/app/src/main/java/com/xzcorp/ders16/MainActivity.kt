package com.xzcorp.ders16

import android.graphics.Color
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var secim:Button
    lateinit var radioGroup: RadioGroup
    lateinit var linearLayout:LinearLayout
    lateinit var sariRadioButton:RadioButton
    lateinit var kirmiziRadioButton: RadioButton
    lateinit var yesilRadioButton: RadioButton
    lateinit var cyanRadioButton: RadioButton
    lateinit var listem:ListView
    lateinit var ratingDegisken:RatingBar
    lateinit var ratinSonuc:TextView

    val yemekler=listOf("Kuru Fasulye","Lahmacun","Pilav","Kebap","Patates Kızartması","İmambayıldı")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        secim=findViewById(R.id.secim)
        radioGroup=findViewById(R.id.renkler)
        linearLayout=findViewById(R.id.main)
        sariRadioButton=findViewById(R.id.sari)
        kirmiziRadioButton=findViewById(R.id.kirmizi)
        yesilRadioButton=findViewById(R.id.yesil)
        cyanRadioButton=findViewById(R.id.cyan)
        listem=findViewById(R.id.listem)
        ratingDegisken=findViewById(R.id.ratingBar)
        ratinSonuc=findViewById(R.id.ratingSonuc)

        val adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,yemekler)
        listem.adapter=adapter
        listem.onItemClickListener=AdapterView.OnItemClickListener{parent,view,position,id->
            val secilenYemek=parent.getItemAtPosition(position) as String
            Toast.makeText(this,"Seçilen yemek= $secilenYemek",Toast.LENGTH_LONG).show()
        }

        secim.setOnClickListener{
            /*
            var secilenRadioButton=radioGroup.checkedRadioButtonId
            when(secilenRadioButton){
                R.id.kirmizi->linearLayout.setBackgroundColor(Color.RED)
                R.id.yesil->linearLayout.setBackgroundColor(Color.GREEN)
                R.id.sari->linearLayout.setBackgroundColor(Color.YELLOW)
                R.id.cyan->linearLayout.setBackgroundColor(Color.CYAN)
            }
             */

            val color=Color.rgb(Random.nextInt(256),Random.nextInt(256),Random.nextInt(256))
            linearLayout.setBackgroundColor(color)
        }

        kirmiziRadioButton.setOnClickListener{
            linearLayout.setBackgroundColor(Color.RED)
        }
        yesilRadioButton.setOnClickListener{
            linearLayout.setBackgroundColor(Color.GREEN)
        }
        sariRadioButton.setOnClickListener{
            linearLayout.setBackgroundColor(Color.YELLOW)
        }
        cyanRadioButton.setOnClickListener{
            linearLayout.setBackgroundColor(Color.CYAN)
        }

        ratingDegisken.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            ratinSonuc.text="Puan = $rating"
        }
    }
}