package com.example.squaregame;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.squaregame.databinding.ActivityReglesBinding;

public class Regles extends AppCompatActivity {
    private ActivityReglesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReglesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    protected void onResume() {
        super.onResume();
        binding.MenuRules.setOnClickListener(v -> {
            Intent intent = new Intent(Regles.this, MenuFR.class);
            startActivity(intent);
        });
    }
}
