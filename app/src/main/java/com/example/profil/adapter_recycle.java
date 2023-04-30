package com.example.profil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter_recycle extends RecyclerView.Adapter<adapter_recycle.MyViewHolder> {

    ArrayList<annonces> list1;
    Context context;

    public adapter_recycle( Context context, ArrayList<annonces> list1) {
        this.context=context;
        this.list1 = list1;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_frags,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        annonces an=list1.get(position);
        holder.nom_produit.setText(an.getNom_produit());
        holder.date_Ajout.setText(an.getDate_Ajout());
    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        //add categorie description and others
        TextView date_Ajout,nom_produit;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            date_Ajout=itemView.findViewById(R.id.date);
            nom_produit=itemView.findViewById(R.id.nom_produit);
        }
    }
}
