package com.example.squaregame;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.squaregame.databinding.ActivityMainBinding;
import com.example.squaregame.model.Joueur;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    private ActivityMainBinding binding;
    int ScoreJ1;
    int ScoreJ2;
    int CouleurRemplissage = 0;
    int CouleurRemplissage2 = 0;
    int CouleurRemplissage3 = 0;
    int CouleurRemplissage4 = 0;
    int CouleurRemplissage5 = 0;
    int CouleurRemplissage6 = 0;
    int CouleurRemplissage7 = 0;
    int CouleurRemplissage8 = 0;
    int CouleurRemplissage9 = 0;
    int ButtonBottomColor = 0;
    int ButtonBottom2Color = 0;
    int ButtonBottom3Color = 0;
    int ButtonBottom4Color = 0;
    int ButtonBottom5Color = 0;
    int ButtonBottom6Color = 0;
    int ButtonBottom7Color = 0;
    int ButtonBottom8Color = 0;
    int ButtonBottom9Color = 0;
    int ButtonLeftColor = 0;
    int ButtonLeft2Color = 0;
    int ButtonLeft3Color = 0;
    int ButtonRightColor = 0;
    int ButtonRight2Color = 0;
    int ButtonRight3Color = 0;
    int ButtonRight4Color = 0;
    int ButtonRight5Color = 0;
    int ButtonRight6Color = 0;
    int ButtonRight7Color = 0;
    int ButtonRight8Color = 0;
    int ButtonRight9Color = 0;
    int ButtonTopColor = 0;
    int ButtonTop2Color = 0;
    int ButtonTop3Color = 0;
    int JoueurActuel =0;
    int NbJoueur = 2;
    Joueur j1 = new Joueur("chevre",0, R.drawable.rouge);
    Joueur j2 = new Joueur("chat",1, R.drawable.vert);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
    @Override
    protected void onResume() {
        super.onResume();
        binding.ButtonTop.setOnClickListener(this);
        binding.ButtonTop2.setOnClickListener(this);
        binding.ButtonTop3.setOnClickListener(this);

        binding.ButtonRight.setOnClickListener(this);
        binding.ButtonRight2.setOnClickListener(this);
        binding.ButtonRight3.setOnClickListener(this);
        binding.ButtonRight4.setOnClickListener(this);
        binding.ButtonRight5.setOnClickListener(this);
        binding.ButtonRight6.setOnClickListener(this);
        binding.ButtonRight7.setOnClickListener(this);
        binding.ButtonRight8.setOnClickListener(this);
        binding.ButtonRight9.setOnClickListener(this);

        binding.ButtonLeft.setOnClickListener(this);
        binding.ButtonLeft2.setOnClickListener(this);
        binding.ButtonLeft3.setOnClickListener(this);

        binding.ButtonBottom.setOnClickListener(this);
        binding.ButtonBottom2.setOnClickListener(this);
        binding.ButtonBottom3.setOnClickListener(this);
        binding.ButtonBottom4.setOnClickListener(this);
        binding.ButtonBottom5.setOnClickListener(this);
        binding.ButtonBottom6.setOnClickListener(this);
        binding.ButtonBottom7.setOnClickListener(this);
        binding.ButtonBottom8.setOnClickListener(this);
        binding.ButtonBottom9.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        int ID = view.getId();
        if(ID == binding.ButtonTop.getId() && ButtonTopColor==0) {
            if (JoueurActuel ==1)
                binding.ButtonTop.setImageResource(j1.getImageResourceId());
            else if (JoueurActuel ==2){
                binding.ButtonTop.setImageResource(j2.getImageResourceId());
            }

            ButtonTopColor = JoueurActuel;
        }
        else if(ID == binding.ButtonTop2.getId() && ButtonTop2Color==0) {
            if (JoueurActuel ==1)
                binding.ButtonTop2.setImageResource(j1.getImageResourceId());
            else if (JoueurActuel ==2){
                binding.ButtonTop2.setImageResource(j2.getImageResourceId());
            }
            ButtonTop2Color = JoueurActuel;
        }
        else if(ID == binding.ButtonTop3.getId() && ButtonTop3Color==0) {
            if (JoueurActuel ==1)
                binding.ButtonTop3.setImageResource(j1.getImageResourceId());
            else if (JoueurActuel ==2){
                binding.ButtonTop3.setImageResource(j2.getImageResourceId());
            }
            ButtonTop3Color = JoueurActuel;
        }
        else if(ID == binding.ButtonRight.getId() && ButtonRightColor==0) {
            if (JoueurActuel ==1)
                binding.ButtonRight.setImageResource(j1.getImageResourceId());
            else if (JoueurActuel ==2){
                binding.ButtonRight.setImageResource(j2.getImageResourceId());
            }

            ButtonRightColor = JoueurActuel;
        }
        else if(ID == binding.ButtonRight2.getId() && ButtonRight2Color==0) {
            if (JoueurActuel ==1)
                binding.ButtonRight2.setImageResource(j1.getImageResourceId());
            else if (JoueurActuel ==2){
                binding.ButtonRight2.setImageResource(j2.getImageResourceId());
            }
            ButtonRight2Color = JoueurActuel;
        }
        else if(ID == binding.ButtonRight3.getId() && ButtonRight3Color==0) {
            if (JoueurActuel ==1)
                binding.ButtonRight3.setImageResource(j1.getImageResourceId());
            else if (JoueurActuel ==2){
                binding.ButtonRight3.setImageResource(j2.getImageResourceId());
            }
            ButtonRight3Color = JoueurActuel;
        }
        else if(ID == binding.ButtonRight4.getId() && ButtonRight4Color==0) {
            if (JoueurActuel ==1)
                binding.ButtonRight4.setImageResource(j1.getImageResourceId());
            else if (JoueurActuel ==2){
                binding.ButtonRight4.setImageResource(j2.getImageResourceId());
            }
            ButtonRight4Color = JoueurActuel;
        }
        else if(ID == binding.ButtonRight5.getId() && ButtonRight5Color==0) {
            if (JoueurActuel ==1)
                binding.ButtonRight5.setImageResource(j1.getImageResourceId());
            else if (JoueurActuel ==2){
                binding.ButtonRight5.setImageResource(j2.getImageResourceId());
            }
            ButtonRight5Color = JoueurActuel;
        }
        else if(ID == binding.ButtonRight6.getId() && ButtonRight6Color==0) {
            if (JoueurActuel ==1)
                binding.ButtonRight6.setImageResource(j1.getImageResourceId());
            else if (JoueurActuel ==2){
                binding.ButtonRight6.setImageResource(j2.getImageResourceId());
            }
            ButtonRight6Color = JoueurActuel;
        }
        else if(ID == binding.ButtonRight7.getId() && ButtonRight7Color==0) {
            if (JoueurActuel ==1)
                binding.ButtonRight7.setImageResource(j1.getImageResourceId());
            else if (JoueurActuel ==2){
                binding.ButtonRight7.setImageResource(j2.getImageResourceId());
            }
            ButtonRight7Color = JoueurActuel;
        }
        else if(ID == binding.ButtonRight8.getId() && ButtonRight8Color==0) {
            if (JoueurActuel ==1)
                binding.ButtonRight8.setImageResource(j1.getImageResourceId());
            else if (JoueurActuel ==2){
                binding.ButtonRight8.setImageResource(j2.getImageResourceId());
            }
            ButtonRight8Color = JoueurActuel;
        }
        else if(ID == binding.ButtonRight9.getId() && ButtonRight9Color==0) {
            if (JoueurActuel ==1)
                binding.ButtonRight9.setImageResource(j1.getImageResourceId());
            else if (JoueurActuel ==2){
                binding.ButtonRight9.setImageResource(j2.getImageResourceId());
            }
            ButtonRight9Color = JoueurActuel;
        }
        else if(ID == binding.ButtonLeft.getId() && ButtonLeftColor==0) {
            if (JoueurActuel ==1)
                binding.ButtonLeft.setImageResource(j1.getImageResourceId());
            else if (JoueurActuel ==2){
                binding.ButtonLeft.setImageResource(j2.getImageResourceId());
            }
            ButtonLeftColor = JoueurActuel;
        }
        else if(ID == binding.ButtonLeft2.getId() && ButtonLeft2Color==0) {
            if (JoueurActuel ==1)
                binding.ButtonLeft2.setImageResource(j1.getImageResourceId());
            else if (JoueurActuel ==2){
                binding.ButtonLeft2.setImageResource(j2.getImageResourceId());
            }
            ButtonLeft2Color = JoueurActuel;
        }
        else if(ID == binding.ButtonLeft3.getId() && ButtonLeft3Color==0) {
            if (JoueurActuel ==1)
                binding.ButtonLeft3.setImageResource(j1.getImageResourceId());
            else if (JoueurActuel ==2){
                binding.ButtonLeft3.setImageResource(j2.getImageResourceId());
            }
            ButtonLeft3Color = JoueurActuel;
        }
        else if(ID == binding.ButtonBottom.getId() && ButtonBottomColor==0) {
            if (JoueurActuel ==1)
                binding.ButtonBottom.setImageResource(j1.getImageResourceId());
            else if (JoueurActuel ==2){
                binding.ButtonBottom.setImageResource(j2.getImageResourceId());
            }
            ButtonBottomColor = JoueurActuel;
        }
        else if(ID == binding.ButtonBottom2.getId() && ButtonBottom2Color==0) {
            if (JoueurActuel ==1)
                binding.ButtonBottom2.setImageResource(j1.getImageResourceId());
            else if (JoueurActuel ==2){
                binding.ButtonBottom2.setImageResource(j2.getImageResourceId());
            }
            ButtonBottom2Color = JoueurActuel;
        }
        else if(ID == binding.ButtonBottom3.getId() && ButtonBottom3Color==0) {
            if (JoueurActuel ==1)
                binding.ButtonBottom3.setImageResource(j1.getImageResourceId());
            else if (JoueurActuel ==2){
                binding.ButtonBottom3.setImageResource(j2.getImageResourceId());
            }
            ButtonBottom3Color = JoueurActuel;
        }
        else if(ID == binding.ButtonBottom4.getId() && ButtonBottom4Color==0) {
            if (JoueurActuel ==1)
                binding.ButtonBottom4.setImageResource(j1.getImageResourceId());
            else if (JoueurActuel ==2){
                binding.ButtonBottom4.setImageResource(j2.getImageResourceId());
            }
            ButtonBottom4Color = JoueurActuel;
        }
        else if(ID == binding.ButtonBottom5.getId() && ButtonBottom5Color==0) {
            if (JoueurActuel ==1)
                binding.ButtonBottom5.setImageResource(j1.getImageResourceId());
            else if (JoueurActuel ==2){
                binding.ButtonBottom5.setImageResource(j2.getImageResourceId());
            }
            ButtonBottom5Color = JoueurActuel;
        }
        else if(ID == binding.ButtonBottom6.getId() && ButtonBottom6Color==0) {
            if (JoueurActuel ==1)
                binding.ButtonBottom6.setImageResource(j1.getImageResourceId());
            else if (JoueurActuel ==2){
                binding.ButtonBottom6.setImageResource(j2.getImageResourceId());
            }
            ButtonBottom6Color = JoueurActuel;
        }
        else if(ID == binding.ButtonBottom7.getId() && ButtonBottom7Color==0) {
            if (JoueurActuel ==1)
                binding.ButtonBottom7.setImageResource(j1.getImageResourceId());
            else if (JoueurActuel ==2){
                binding.ButtonBottom7.setImageResource(j2.getImageResourceId());
            }
            ButtonBottom7Color = JoueurActuel;
        }
        else if(ID == binding.ButtonBottom8.getId() && ButtonBottom8Color==0) {
            if (JoueurActuel ==1)
                binding.ButtonBottom8.setImageResource(j1.getImageResourceId());
            else if (JoueurActuel ==2){
                binding.ButtonBottom8.setImageResource(j2.getImageResourceId());
            }
            ButtonBottom8Color = JoueurActuel;
        }
        else if(ID == binding.ButtonBottom9.getId() && ButtonBottom9Color==0) {
            if (JoueurActuel ==1)
                binding.ButtonBottom9.setImageResource(j1.getImageResourceId());
            else if (JoueurActuel ==2){
                binding.ButtonBottom9.setImageResource(j2.getImageResourceId());
            }
            ButtonBottom9Color = JoueurActuel;
        }
        if (CouleurRemplissage == 0 && ButtonTopColor != 0 && ButtonBottomColor !=0 && 0 != ButtonRightColor && 0 != ButtonLeftColor)
        {
            if (JoueurActuel ==1){
                CouleurRemplissage = JoueurActuel;
                binding.Remplissage.setImageResource(j1.getImageResourceId());}
            else if (JoueurActuel ==2){
                binding.Remplissage.setImageResource(j2.getImageResourceId());
                CouleurRemplissage = JoueurActuel;}
        }
        if (CouleurRemplissage2 == 0 && ButtonTop2Color != 0 && ButtonBottom2Color != 0 && 0 != ButtonRight2Color && ButtonRightColor !=0)
        {
            if (JoueurActuel ==1){
                CouleurRemplissage2 = JoueurActuel;
                binding.Remplissage2.setImageResource(j1.getImageResourceId());}
            else if (JoueurActuel ==2){
                CouleurRemplissage2 = JoueurActuel;
                binding.Remplissage2.setImageResource(j2.getImageResourceId());}
        }
        if (CouleurRemplissage3 == 0 && ButtonTop3Color != 0 && ButtonBottom3Color != 0 && 0 != ButtonRight3Color && ButtonRight2Color != 0)
        {
            if (JoueurActuel ==1){
                CouleurRemplissage3 = JoueurActuel;
                binding.Remplissage3.setImageResource(j1.getImageResourceId());}
            else if (JoueurActuel ==2){
                CouleurRemplissage3 = JoueurActuel;
                binding.Remplissage3.setImageResource(j2.getImageResourceId());}
        }
        if (CouleurRemplissage4 == 0 && ButtonBottomColor != 0 && ButtonBottom4Color !=0 &&  ButtonRight4Color != 0 && ButtonLeft2Color != 0)
        {
            if (JoueurActuel ==1){
                CouleurRemplissage4 = JoueurActuel;
                binding.Remplissage4.setImageResource(j1.getImageResourceId());}
            else if (JoueurActuel ==2){
                CouleurRemplissage4 = JoueurActuel;
                binding.Remplissage4.setImageResource(j2.getImageResourceId());}
        }
        if (CouleurRemplissage5 == 0 && ButtonBottom2Color == ButtonBottom5Color && ButtonBottom5Color == ButtonRight5Color && ButtonRight4Color == ButtonRight5Color && ButtonRight5Color != 0)
        {
            if (JoueurActuel ==1){
                CouleurRemplissage5 = JoueurActuel;
                binding.Remplissage5.setImageResource(j1.getImageResourceId());}
            else if (JoueurActuel ==2){
                CouleurRemplissage5 = JoueurActuel;
                binding.Remplissage5.setImageResource(j2.getImageResourceId());}
        }
        if (CouleurRemplissage6 == 0 && ButtonBottom3Color == ButtonBottom6Color && ButtonBottom6Color == ButtonRight6Color && ButtonRight5Color == ButtonRight6Color && ButtonRight6Color != 0)
        {
            if (JoueurActuel ==1){
                CouleurRemplissage6 = JoueurActuel;
                binding.Remplissage6.setImageResource(j1.getImageResourceId());}
            else if (JoueurActuel ==2){
                CouleurRemplissage6 = JoueurActuel;
                binding.Remplissage6.setImageResource(j2.getImageResourceId());}
        }
        if (CouleurRemplissage7 == 0 && ButtonBottom4Color == ButtonBottom7Color && ButtonBottom7Color == ButtonRight7Color && ButtonLeft3Color == ButtonRight7Color && ButtonLeft3Color != 0)
        {
            if (JoueurActuel ==1){
                CouleurRemplissage7 = JoueurActuel;
                binding.Remplissage7.setImageResource(j1.getImageResourceId());}
            else if (JoueurActuel ==2){
                CouleurRemplissage7 = JoueurActuel;
                binding.Remplissage7.setImageResource(j2.getImageResourceId());}
        }
        if (CouleurRemplissage8 == 0 && ButtonBottom5Color == ButtonBottom8Color && ButtonBottom8Color == ButtonRight8Color && ButtonRight7Color == ButtonRight8Color && ButtonRight7Color != 0)
        {
            if (JoueurActuel ==1){
                CouleurRemplissage8 = JoueurActuel;
                binding.Remplissage8.setImageResource(j1.getImageResourceId());}
            else if (JoueurActuel ==2){
                CouleurRemplissage8 = JoueurActuel;
                binding.Remplissage8.setImageResource(j2.getImageResourceId());}
        }
        if (CouleurRemplissage9 == 0 && ButtonBottom6Color == ButtonBottom9Color && ButtonBottom9Color == ButtonRight9Color && ButtonRight8Color == ButtonRight9Color && ButtonRight9Color != 0)
        {
            if (JoueurActuel ==1){
                CouleurRemplissage9 = JoueurActuel;
                binding.Remplissage9.setImageResource(j1.getImageResourceId());}
            else if (JoueurActuel ==2){
                CouleurRemplissage9 = JoueurActuel;
                binding.Remplissage9.setImageResource(j2.getImageResourceId());}
        }
        JoueurActuel = (JoueurActuel%NbJoueur)+1;
    }
}