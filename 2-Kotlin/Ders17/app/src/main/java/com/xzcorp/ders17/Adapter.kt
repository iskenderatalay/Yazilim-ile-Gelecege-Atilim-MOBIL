package com.xzcorp.ders17

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(val countryList:MutableList<CountryModel>):RecyclerView.Adapter<Adapter.ModelViewHolder>(){

    class ModelViewHolder(view: View):RecyclerView.ViewHolder(view){
        val countryName:TextView=view.findViewById(R.id.ulkeAdi)
        val capitalName:TextView=view.findViewById(R.id.baskentAdi)
        val flagImage:ImageView=view.findViewById(R.id.flagImage)
        val buton:Button=view.findViewById(R.id.mars)


        fun bindItems(item:CountryModel){
            countryName.text=item.countryName
            capitalName.text=item.capitalName
            flagImage.setImageResource(item.flagName)
            buton.setOnClickListener{
                //marşı çal
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_card,parent,false)
        return ModelViewHolder(view)
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        holder.bindItems((countryList.get(position)))
    }

    override fun getItemCount(): Int {
        return countryList.size
    }
}