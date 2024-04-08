package com.example.squaregame.model;

import android.content.Context;
import android.widget.ImageView;

public class Joueur {
    private String pseudo;
    private int id;
    private int imageResourceId;

    public Joueur(String pseudo, int id, int imageResourceId) {
        this.pseudo = pseudo;
        this.id = id;
        this.imageResourceId = imageResourceId;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    // Méthode pour obtenir l'ImageView avec l'image correspondante
    public ImageView getImageView(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(imageResourceId);
        return imageView;
    }
}
