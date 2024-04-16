package com.example.squaregame;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MenuFR extends AppCompatActivity {
    private com.example.squaregame.databinding.ActivityMenuFrBinding binding;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = com.example.squaregame.databinding.ActivityMenuFrBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        RadioGroup radioGroup = findViewById(R.id.radioGroup_nbJoueur);
        radioGroup.check(radioGroup.getId());
    }

    @Override
    protected void onResume() {
        super.onResume();
        binding.start.setOnClickListener(v -> {
            Joueur j = new Joueur(binding.nomdujoueur1.getText().toString(), binding.nomdujoueur2.getText().toString(),binding.grille5.getText().toString());
            Intent intent = new Intent(MenuFR.this, Reception.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("JOUEUR",j);
            intent.putExtras(bundle);
            startActivity(intent);
        });
        binding.regles.setOnClickListener(v -> {
            Intent intent = new Intent(MenuFR.this,Regles.class);
            startActivity(intent);
        });
        binding.langages.setOnClickListener(v -> {
            Intent intent = new Intent(MenuFR.this,Langages.class);
            startActivity(intent);
        });
    }
}
