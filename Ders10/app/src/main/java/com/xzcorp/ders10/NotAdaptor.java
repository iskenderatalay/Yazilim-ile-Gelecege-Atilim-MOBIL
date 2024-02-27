package com.xzcorp.ders10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotAdaptor extends RecyclerView.Adapter<NotAdaptor.ViewHolder>
{
    public Context context;
    ArrayList<Notlar> notListesi;
    View.OnClickListener kendimTiklayacagim;
    NotAdaptor(Context context,ArrayList<Notlar>liste) {
        this.notListesi=liste;
        this.context=context;
    }

    @NonNull
    @Override
    public NotAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.liste_item_tasarim,parent,false);
        return new NotAdaptor.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotAdaptor.ViewHolder holder, int position) {
        holder.notIcerik.setText(notListesi.get(position).getNotIcerigi());
    }

    @Override
    public int getItemCount(){
        return notListesi.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView notIcerik;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            notIcerik=itemView.findViewById(R.id.satir);
            itemView.setTag(this);
            itemView.setOnClickListener(kendimTiklayacagim);
        }
    }

    public void setOnItemClickListener(View.OnClickListener itemClickListener) {
        kendimTiklayacagim=itemClickListener;
    }
}