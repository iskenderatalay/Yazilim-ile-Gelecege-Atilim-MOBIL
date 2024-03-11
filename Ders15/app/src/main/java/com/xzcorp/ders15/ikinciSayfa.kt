package com.xzcorp.ders15

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView

class ikinciSayfa : Activity() {

    //lateinit degerini sonradan verilecek

    lateinit var ikincisayfaTextDegisken:TextView
    lateinit var javaCheck:CheckBox
    lateinit var flutterCheck: CheckBox
    lateinit var kotlinCheck: CheckBox

    lateinit var secimButton: Button
    lateinit var sonucTextView: TextView

    var sayi=100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ikincisayfa)

        sayi=200
        //sayi="dd" //ilk int olduğundan stringi kabul etmez

        val adSoyad:String by lazy{ //lazy kod cağrıldığında atama yapar
            "huseyin bodur"
        } //val javadaki final gibidir.

        ikincisayfaTextDegisken=findViewById(R.id.ikincisayfatxt)
        javaCheck=findViewById(R.id.java)
        flutterCheck=findViewById(R.id.flutter)
        kotlinCheck=findViewById(R.id.kotlin)

        secimButton=findViewById(R.id.secim)
        sonucTextView=findViewById(R.id.sonuc)

        var gelenVeri:String?=intent.getStringExtra("veri")
        ikincisayfaTextDegisken.text=gelenVeri

        secimButton.setOnClickListener {
            var result=""
            if(kotlinCheck.isChecked)
                result+="\nkotlin"
            if(flutterCheck.isChecked)
                result+="\nflutter"
            if(javaCheck.isChecked)
                result+="\njava"

            sonucTextView.text=result
        }
    }
}