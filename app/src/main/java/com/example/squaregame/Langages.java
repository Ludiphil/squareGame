package com.example.squaregame;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.squaregame.databinding.ActivityLangagesBinding;

public class Langages extends AppCompatActivity {
    private ActivityLangagesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLangagesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    protected void onResume() {
        super.onResume();
        binding.MenuLangagesEN.setOnClickListener(v -> {
            Intent intent = new Intent(Langages.this, MenuEN.class);
            startActivity(intent);
        });
        binding.MenuLangagesFR.setOnClickListener(v -> {
            Intent intent = new Intent(Langages.this, MenuFR.class);
            startActivity(intent);
        });
    }
}


