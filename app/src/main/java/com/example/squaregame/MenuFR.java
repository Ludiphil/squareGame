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
