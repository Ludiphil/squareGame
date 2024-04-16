package com.example.squaregame;

import android.content.Context;
import android.widget.ImageView;

import java.io.Serializable;

public class Joueur implements Serializable {
    protected final String playerName1;
    protected final String playerName2;
    protected final String grillSize;
    public int imageResourceIdJ1 = R.drawable.rouge;
    public int imageResourceIdJ2 = R.drawable.vert;

    Joueur(String playerName1, String playerName2, String grillSize) {
        this.playerName1 = playerName1;
        this.playerName2 = playerName2;
        this.grillSize = grillSize;
    }
    public String getPlayerName1() {
        return this.playerName1;
    }
    public String getPlayerName2() {
        return this.playerName2;
    }
    public String getGrillSize() {
        return this.grillSize;
    }

}
