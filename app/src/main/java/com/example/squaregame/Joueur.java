package com.example.squaregame;

import java.io.Serializable;

public class Joueur implements Serializable {
    protected final String playerName;
    protected final String grillSize;
    Joueur(String playerName, String grillSize) {
        this.playerName = playerName;
        this.grillSize = grillSize;
    }
    public String getFirstName() {
        return this.playerName;
    }
    public String getLastName() {
        return this.grillSize;
    }

}
