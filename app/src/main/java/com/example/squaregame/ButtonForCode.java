package com.example.squaregame;

public class ButtonForCode {
    private int id;
    private boolean isSelected;

    // Constructeur
    public ButtonForCode(int id) {
        this.id = id;
        this.isSelected = false;
    }



    // Getter pour id
    public int getId() {
        return id;
    }

    // Setter pour id
    public void setId(int id) {
        this.id = id;
    }

    // Getter pour isSelected
    public boolean isSelected() {
        return isSelected;

    }

    // Setter pour isSelected
    public void setSelected() {
        this.isSelected = true;
    }
}