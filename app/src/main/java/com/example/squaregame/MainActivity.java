package com.example.squaregame;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Trait[] board = new Trait[49];
        for (int i = 0; i < 49; i++) {
            Trait trait = new Trait(i);
            board[i] = trait;
            System.out.println(board[i].getId());
        }
    }
}