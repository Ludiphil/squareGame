package com.example.squaregame;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.squaregame.databinding.ActivityRulesBinding;

public class Rules extends AppCompatActivity {
    private ActivityRulesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRulesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    protected void onResume() {
        super.onResume();
        binding.MenuRules.setOnClickListener(v -> {
            Intent intent = new Intent(Rules.this, MenuEN.class);
            startActivity(intent);
        });
    }
}
