package com.example.squaregame;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.squaregame.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding binding;

    int numButtons = 5; // Nombre de boutons à afficher
    int value = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        LinearLayout buttonContainer = findViewById(R.id.buttonContainer);

        // Récupérer la hauteur de l'écran
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenHeight = displayMetrics.heightPixels;

        // Calculer la hauteur des boutons
        int buttonHeight = screenHeight / 40; // 5% de la hauteur de l'écran

        // Créer et ajouter les boutons dynamiquement
        for (int i = 0; i < numButtons; i++) {
            ImageButton button = new ImageButton(this);
            button.setId(ViewCompat.generateViewId()); // Générer un ID unique pour chaque bouton
            button.setImageResource(R.drawable.gris); // Image par défaut
            button.setOnClickListener(this);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    0, // largeur 0 pour un poids égal
                    buttonHeight // hauteur calculée
            );
            params.weight = 1; // poids égal pour chaque bouton
            if (i != 0) {
                params.setMarginStart(100); // Espacement de 10 pixels
            }
            button.setLayoutParams(params);

            buttonContainer.addView(button);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Vous pouvez ajouter un écouteur aux boutons si nécessaire
    }

    @Override
    public void onClick(View view) {
        // Gérer les clics de bouton ici si nécessaire
    }
}
