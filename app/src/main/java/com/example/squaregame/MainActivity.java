package com.example.squaregame;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.squaregame.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding binding;
    int Value = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onResume() {
        super.onResume();
        binding.Button1.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        int ID = view.getId();
        if(ID == binding.Button1.getId()) {
            if ((Value%2)==0){
                binding.Button1.setImageResource(R.drawable.rouge);
            }
            else{
                binding.Button1.setImageResource(R.drawable.gris);
            }
            Value = Value+1;

        }
    }



}