package com.example.profil;

public class annonces {
    String categorie,description,date_Ajout,nom_produit,userId,image;

    public annonces( String date_Ajout, String nom_produit) {
        this.date_Ajout = date_Ajout;
        this.nom_produit = nom_produit;

    }

    public String getCategorie() {
        return categorie;
    }

    public String getDescription() {
        return description;
    }

    public String getDate_Ajout() {
        return date_Ajout;
    }

    public String getNom_produit() {
        return nom_produit;
    }

    public String getUserId() {
        return userId;
    }

    public String getImage() {
        return image;
    }
}
