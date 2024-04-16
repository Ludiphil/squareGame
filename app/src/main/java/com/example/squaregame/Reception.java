package com.example.squaregame;

import android.os.Bundle;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.example.squaregame.Joueur;
import com.example.squaregame.databinding.ActivityReceptionBinding;

public class Reception extends AppCompatActivity {
    private com.example.squaregame.databinding.ActivityReceptionBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityReceptionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Joueur j = (Joueur) bundle.getSerializable("JOUEUR");
        binding.PlayerName1.setText(j.getPlayerName1());
        binding.PlayerName2.setText(j.getPlayerName2());
    }
}