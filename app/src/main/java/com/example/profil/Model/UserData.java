package com.example.profil.Model;

import android.content.Intent;

import com.example.profil.AjoutProduit;

public class UserData {
    public String nomComplet,phone,address,pays,ville,description;

    public UserData(String nomComplet,String phone,String address,String pays,String ville,String description){
        this.nomComplet= nomComplet;
        this.phone= phone;
        this.pays=pays;
        this.ville=ville;
        this.address= address;
        this.description= description;
    }
}

