package com.xzcorp.odevrehber;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactViewHolder extends RecyclerView.ViewHolder {
    TextView textViewName,textViewNumber;
    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewName=itemView.findViewById(R.id.txt_contact_name);
        textViewNumber=itemView.findViewById(R.id.txt_contact_number);
    }
}
