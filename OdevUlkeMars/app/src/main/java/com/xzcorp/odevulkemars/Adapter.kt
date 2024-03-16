package com.xzcorp.odevulkemars

import android.media.MediaPlayer
import android.net.Uri
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.storage.storage
import java.io.File

class Adapter(val countryList:MutableList<CountryModel>): RecyclerView.Adapter<Adapter.ModelViewHolder>(){
    class ModelViewHolder(view: View): RecyclerView.ViewHolder(view){
        val countryName:TextView = view.findViewById(R.id.ulkeAdi)
        val capitalName:TextView = view.findViewById(R.id.baskentAdi)
        val flagImage:ImageView = view.findViewById(R.id.flagImage)

        val playButon:ImageButton = view.findViewById(R.id.play)
        val stopButon:ImageButton = view.findViewById(R.id.stop)

        lateinit var sesCal: MediaPlayer

        fun bindItems(item:CountryModel){
            countryName.text = item.countryName
            capitalName.text = item.capitalName
            flagImage.setImageResource(item.flagName)

            val sesAd = item.sesDosyasi
            val sesDosya = Environment.getExternalStorageDirectory().path + "/Download/"+sesAd

            playButon.setOnClickListener {
                sesCal = MediaPlayer.create(it.context, Uri.parse(sesDosya))
                sesCal.start()
            }

            stopButon.setOnClickListener {
                if(sesCal.isPlaying)
                    sesCal.stop()
            }

            for(item in sesAd )
                downloadMp3(sesAd)
        }

        fun downloadMp3(mp3Name: String){
            val indirilecekYol = Environment.getExternalStorageDirectory().toString() + File.separator + "Download/"
            val indirilecekYoldakiKlasor = File(indirilecekYol)
            if (!indirilecekYoldakiKlasor.exists())
                indirilecekYoldakiKlasor.mkdirs()
            val indirilecekMp3 = indirilecekYol+mp3Name
            val indirilecekMp3Dosyasi = File(indirilecekMp3)

            if(!indirilecekMp3Dosyasi.exists()){

                var storage = com.google.firebase.Firebase.storage.getReference().child("/"+mp3Name)
                val mp3Urisi = Uri.fromFile(indirilecekMp3Dosyasi)

                storage.getFile(mp3Urisi).addOnSuccessListener {
                    Toast.makeText(itemView.context,"Mp3 İniyor Bekleyin", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener {
                    Toast.makeText(itemView.context, "Mp3 İndirmede Hata", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card,parent,false)
        return ModelViewHolder(view)
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        holder.bindItems((countryList.get(position)))
    }

    override fun getItemCount(): Int {
        return countryList.size
    }
}