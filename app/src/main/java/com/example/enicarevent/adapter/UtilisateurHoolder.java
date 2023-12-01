package com.example.enicarevent.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.enicarevent.R;

public class UtilisateurHoolder extends RecyclerView.ViewHolder {

    public TextView t1;
    public TextView t2;
    public UtilisateurHoolder(@NonNull View itemView) {
        super(itemView);
        t1 =itemView.findViewById(R.id.nomU);
        t1 =itemView.findViewById(R.id.PrenomU);
    }
}
