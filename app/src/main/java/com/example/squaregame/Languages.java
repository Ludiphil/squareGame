package com.example.squaregame;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.squaregame.databinding.ActivityLanguagesBinding;

public class Languages extends AppCompatActivity {
    private ActivityLanguagesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLanguagesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    protected void onResume() {
        super.onResume();
        binding.MenuLanguagesEN.setOnClickListener(v -> {
            Intent intent = new Intent(Languages.this, MenuEN.class);
            startActivity(intent);
        });
        binding.MenuLanguagesFR.setOnClickListener(v -> {
            Intent intent = new Intent(Languages.this, MenuFR.class);
            startActivity(intent);
        });
    }
}


