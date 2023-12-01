package com.example.enicarevent.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.enicarevent.R;
import com.example.enicarevent.model.Utilisateur;

import java.util.List;

public class UtilisateurAdapter extends RecyclerView.Adapter<UtilisateurHoolder> {
    private List<Utilisateur> utilisateurList;

    public UtilisateurAdapter(List<Utilisateur> utilisateurList) {
        this.utilisateurList = utilisateurList;
    }

    @NonNull
    @Override
    public UtilisateurHoolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from((parent.getContext())).inflate(R.layout.list_utilisateur_item,parent,false);
        return new UtilisateurHoolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull UtilisateurHoolder holder, int position) {
    Utilisateur utilisateur= utilisateurList.get(position);
    holder.t1.setText(utilisateur.getNom());
    holder.t2.setText(utilisateur.getPrenom());
    }

    @Override
    public int getItemCount() {
        return utilisateurList.size();
    }
}
