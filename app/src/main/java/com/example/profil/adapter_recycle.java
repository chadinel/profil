package com.example.profil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class adapter_recycle extends RecyclerView.Adapter<adapter_recycle.MyViewHolder> {

    ArrayList<annonces> list1;
    Context context;
    String idann;

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
        idann=an.getIDannonce();
        holder.ed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
            }
        });
        holder.del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Produits").child(idann);
                ref.removeValue();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        //add categorie description and others
        TextView date_Ajout,nom_produit; Button ed,del;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            date_Ajout=itemView.findViewById(R.id.date);
            nom_produit=itemView.findViewById(R.id.nom_produit);
            ed=itemView.findViewById(R.id.ed1);
            del=itemView.findViewById(R.id.del1);
            //ed.setId(View.generateViewId());
            //del.setId(View.generateViewId());

        }
    }
}
