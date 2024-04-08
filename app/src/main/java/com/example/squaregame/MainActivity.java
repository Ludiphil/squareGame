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
    int ButtonBottomColor = 0;
    int ButtonLeftColor = 0;
    int ButtonRightColor = 0;
    int ButtonTopColor = 0;
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
        binding.ButtonRight.setOnClickListener(this);
        binding.ButtonLeft.setOnClickListener(this);
        binding.ButtonBottom.setOnClickListener(this);

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
        else if(ID == binding.ButtonRight.getId() && ButtonRightColor==0) {
            if (JoueurActuel ==1)
                binding.ButtonRight.setImageResource(j1.getImageResourceId());
            else if (JoueurActuel ==2){
                binding.ButtonRight.setImageResource(j2.getImageResourceId());
            }

            ButtonRightColor = JoueurActuel;
        }
        else if(ID == binding.ButtonLeft.getId() && ButtonLeftColor==0) {
            if (JoueurActuel ==1)
                binding.ButtonLeft.setImageResource(j1.getImageResourceId());
            else if (JoueurActuel ==2){
                binding.ButtonLeft.setImageResource(j2.getImageResourceId());
            }
            ButtonLeftColor = JoueurActuel;
        }
        else if(ID == binding.ButtonBottom.getId() && ButtonBottomColor==0) {
            if (JoueurActuel ==1)
                binding.ButtonBottom.setImageResource(j1.getImageResourceId());
            else if (JoueurActuel ==2){
                binding.ButtonBottom.setImageResource(j2.getImageResourceId());
            }
            ButtonBottomColor = JoueurActuel;
        }

        if (ButtonTopColor == ButtonBottomColor && ButtonBottomColor == ButtonRightColor && ButtonRightColor == ButtonLeftColor && ButtonLeftColor != 0)
        {
            if (JoueurActuel ==1)
                binding.Remplissage.setImageResource(j1.getImageResourceId());
            else if (JoueurActuel ==2)
                binding.Remplissage.setImageResource(j2.getImageResourceId());
        }
        JoueurActuel = (JoueurActuel%NbJoueur)+1;
    }


}