package com.example.squaregame;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MenuEN extends AppCompatActivity {
    private com.example.squaregame.databinding.ActivityMenuEnBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = com.example.squaregame.databinding.ActivityMenuEnBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    protected void onResume() {
        super.onResume();
        binding.rules.setOnClickListener(v -> {
            Intent intent = new Intent(MenuEN.this,Rules.class);
            startActivity(intent);
        });
        binding.languages.setOnClickListener(v -> {
            Intent intent = new Intent(MenuEN.this,Languages.class);
            startActivity(intent);
        });
    }
}