package com.example.profil;

public class annonces {
    String categorie,description,date_Ajout,nom_produit,userId,image;

    public annonces(String categorie, String description, String date_Ajout, String nom_produit, String userId, String image) {
        this.categorie = categorie;
        this.description = description;
        this.date_Ajout = date_Ajout;
        this.nom_produit = nom_produit;
        this.userId = userId;
        this.image = image;
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
