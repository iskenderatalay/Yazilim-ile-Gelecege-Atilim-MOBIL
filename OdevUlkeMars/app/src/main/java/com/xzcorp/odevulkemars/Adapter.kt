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
import androidx.recyclerview.widget.RecyclerView

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