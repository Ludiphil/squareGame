package com.example.squaregame;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
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

    int numButtons = 5; // Nombre de boutons à afficher par ligne
    int numLines = 5; // Nombre de lignes à afficher
    int value = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        LinearLayout buttonContainer = findViewById(R.id.buttonContainer);

        // Récupérer les dimensions de l'écran
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;

        // Calculer la largeur des boutons en pourcentage de l'écran
        int buttonWidthPercent = 10; // 10% de la largeur de l'écran
        int buttonWidth = (screenWidth * buttonWidthPercent) / 100;

        // Calculer la hauteur des boutons en pourcentage de l'écran
        int buttonHeightPercent = 5; // 5% de la hauteur de l'écran
        int buttonHeight = (screenHeight * buttonHeightPercent) / (100 * numLines + 1);

        // Créer une disposition verticale pour les boutons
        LinearLayout verticalLayout = new LinearLayout(this);
        verticalLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        ));
        verticalLayout.setOrientation(LinearLayout.VERTICAL);

        // Calculer l'espacement entre les lignes
        int rowSpacing = 60; // Espacement entre les lignes en pixels

        // Créer et ajouter les boutons dynamiquement pour chaque ligne
        for (int j = 0; j < numLines; j++) {
            LinearLayout rowLayout = new LinearLayout(this);
            rowLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            rowLayout.setOrientation(LinearLayout.HORIZONTAL);

            for (int i = 0; i < numButtons; i++) {
                ImageButton button = new ImageButton(this);
                int id = ViewCompat.generateViewId();
                System.out.println("ID: " + id);
                button.setId(id); // Générer un ID unique pour chaque bouton
                button.setImageResource(R.drawable.gris); // Image par défaut
                button.setOnClickListener(this);

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        buttonWidth + 30, // largeur calculée
                        buttonHeight + 30 // hauteur calculée
                );
                if(i == 0){
                    params.setMarginStart(100); // Espacement de 100 pixels
                }
                if (i != 0) {
                    params.setMarginStart(25); // Espacement de 100 pixels
                }
                button.setLayoutParams(params);

                rowLayout.addView(button);
            }
            if (j != numLines - 1) {
                for (int i = 0; i < numLines + 1; i++) {
                    ImageButton button = new ImageButton(this);
                    int id = ViewCompat.generateViewId();
                    System.out.println("ID: " + id);
                    button.setId(id); // Générer un ID unique pour chaque bouton
                    button.setImageResource(R.drawable.gris); // Image par défaut
                    button.setOnClickListener(this);


                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                            buttonHeight+30, // largeur calculée
                            buttonWidth+30 // hauteur calculée
                    );
                    if (i == 0) {
                        params.setMargins(-830,30,0,0); // Espacement de 100 pixels
                    }
                    if(i != 0){
                        params.setMargins(110,30,0,0); // Espacement de 100 pixels
                    }
                    button.setLayoutParams(params);

                    rowLayout.addView(button);
                    if(i != numLines){
                        // Ajouter une ImageView après chaque ImageButton
                        ImageView imageView = new ImageView(this);
                        imageView.setImageResource(R.drawable.gris); // Image par défaut
                        LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(
                                100, // largeur en pixels
                                100 // hauteur en pixels
                        );

                        imageParams.setMargins(5, 55, -100, 0); // Ajouter une marge supérieure de 50 pixels
                        imageView.setLayoutParams(imageParams);
                        rowLayout.addView(imageView);
                    }

                }
            }


            // Ajouter la ligne au conteneur vertical
            verticalLayout.addView(rowLayout);

            // Ajouter un espacement entre les lignes, sauf pour la dernière ligne
            if (j != numLines - 1) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) rowLayout.getLayoutParams();
                layoutParams.bottomMargin = rowSpacing;
                rowLayout.setLayoutParams(layoutParams);
            }
        }




        // Ajouter la disposition verticale contenant les boutons à la vue principale
        buttonContainer.addView(verticalLayout);

    }

    @Override
    protected void onResume() {
        super.onResume();
        LinearLayout buttonContainer = findViewById(R.id.buttonContainer);
        LinearLayout verticalLayout = (LinearLayout) buttonContainer.getChildAt(0); // Récupérer le verticalLayout

        for (int i = 0; i < verticalLayout.getChildCount(); i++) {
            LinearLayout rowLayout = (LinearLayout) verticalLayout.getChildAt(i); // Récupérer chaque rowLayout

            for (int j = 0; j < rowLayout.getChildCount(); j++) {
                View child = rowLayout.getChildAt(j);
                if (child instanceof ImageButton) {
                    System.out.println("ImageButton found with id: " + child.getId());
                    ((ImageButton) child).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ImageButton button = (ImageButton) v;
                            if (value == 0) {
                                button.setImageResource(R.drawable.rouge);
                                value = 1;
                            } else {
                                button.setImageResource(R.drawable.gris);
                                value = 0;
                            }
                        }
                    });
                }
            }
        }
    }

    @Override
    public void onClick(View view) {
        // Gérer les clics de bouton ici si nécessaire
    }
}




