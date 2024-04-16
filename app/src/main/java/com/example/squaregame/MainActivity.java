package com.example.squaregame;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import com.example.squaregame.databinding.ActivityMainBinding;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding binding;
    private MediaPlayer mediaPlayer;
    private long currentElapsedTime = 0;
    int numButtons = 5; // Nombre de boutons à afficher par ligne
    int numLines = 6; // Nombre de lignes à afficher
    int value = 0;

    int j1 = 0;
    int j2 = 3;
    GamePreferences gamePrefs;
    int meilleurScore;
    String meilleurJoueur;



    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            long elapsedTime = intent.getLongExtra("elapsedTime", 0);
            updateUI(elapsedTime);
        }
    };
    private void updateUI(long elapsedTime) {
        int seconds = (int) (elapsedTime / 1000);
        int minutes = seconds / 60;
        seconds = seconds % 60;
        binding.Chrono.setText(String.format("%02d:%02d", minutes, seconds));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mediaPlayer = MediaPlayer.create(this, R.raw.musiquefond);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        Intent chrono = new Intent(getApplicationContext(),Chrono.class);
        startService(chrono);

        gamePrefs = new GamePreferences(getApplicationContext());
        gamePrefs.saveBestScore(0, "Chèvre");
        meilleurScore = gamePrefs.getBestScore();
        meilleurJoueur = gamePrefs.getBestPlayerName();


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        updateUI(0);
        LinearLayout buttonContainer = findViewById(R.id.buttonContainer);
        binding.BestScore.setText(String.format("%sd Avec %02d", meilleurJoueur, meilleurScore));
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
        int rowSpacing = 5; // Espacement entre les lignes en pixels

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
                button.setId(id); // Générer un ID unique pour chaque bouton
                button.setImageResource(R.drawable.gris); // Image par défaut
                button.setOnClickListener(this);

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        buttonWidth + 30, // largeur calculée
                        buttonHeight + 30 // hauteur calculée
                );
                if (i == 0) {
                    params.setMarginStart(100); // Espacement de 100 pixels
                }
                if (i != 0) {
                    params.setMarginStart(25); // Espacement de 100 pixels
                }
                button.setLayoutParams(params);
                rowLayout.addView(button);

                //rowLayout.addView(button);
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
                        params.setMargins(-830,30,2,0); // Espacement de 100 pixels
                    }
                    if(i != 0){
                        params.setMargins(110,30,2,0); // Espacement de 100 pixels
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
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
        registerReceiver(broadcastReceiver, new IntentFilter("chrono-tick"));
        LinearLayout buttonContainer = findViewById(R.id.buttonContainer);
        LinearLayout verticalLayout = (LinearLayout) buttonContainer.getChildAt(0); // Récupérer le verticalLayout
        HashMap<Integer, ButtonForCode> buttonMap = new HashMap<>();

        for (int i = 0; i < verticalLayout.getChildCount(); i++) {
            LinearLayout rowLayout = (LinearLayout) verticalLayout.getChildAt(i); // Récupérer chaque rowLayout
            for (int j = 0; j < rowLayout.getChildCount(); j++) {
                View child = rowLayout.getChildAt(j);
                if (child instanceof ImageButton) {
                    System.out.println("ImageButton found with id: " + child.getId());
                    ButtonForCode buttonForCode = new ButtonForCode(child.getId());
                    buttonMap.put(child.getId(), buttonForCode);
                    ((ImageButton) child).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ImageButton button = (ImageButton) v;
                            buttonForCode.setSelected();
                            System.out.println("Button clicked with id: " + buttonForCode.getId() + " isSelected: " + buttonForCode.isSelected());
                            if (buttonForCode.isSelected()){
                                button.setImageResource(R.drawable.rouge);
                                value = 1;
                                j1 = j1 +1;
                                System.out.println(j1);
                            } else {
                                button.setImageResource(R.drawable.gris);
                                value = 0;
                            }
                            if (meilleurScore < j1){
                                gamePrefs.saveBestScore(j1, "J1");
                                meilleurScore = gamePrefs.getBestScore(); // Récupérer le nouveau meilleur score
                                meilleurJoueur = gamePrefs.getBestPlayerName(); // Récupérer le nouveau meilleur joueur
                                binding.BestScore.setText(String.format("%s Avec %02d", meilleurJoueur, meilleurScore)); // Mettre à jour le texte
                            }
                            if (meilleurScore < j2){
                                gamePrefs.saveBestScore(j2, "J2");
                                meilleurScore = gamePrefs.getBestScore(); // Récupérer le nouveau meilleur score
                                meilleurJoueur = gamePrefs.getBestPlayerName(); // Récupérer le nouveau meilleur joueur
                                binding.BestScore.setText(String.format("%s Avec %02d", meilleurJoueur, meilleurScore)); // Mettre à jour le texte
                            }
                            ButtonForCode buttonCompare = buttonMap.get(1);
                            ButtonForCode buttonCompare2 = buttonMap.get(6);
                            ButtonForCode buttonCompare3 = buttonMap.get(12);
                            System.out.println(buttonCompare.isSelected());
                            System.out.println(buttonCompare2.isSelected());
                            System.out.println(buttonCompare3.isSelected());
                            if(buttonForCode.getId() == 7 && buttonForCode.isSelected() && buttonCompare.isSelected() && buttonCompare2.isSelected() && buttonCompare3.isSelected()){
                                System.out.println("Gagné");
                                int cptImageView = 0;
                                LinearLayout rowLayout2 = (LinearLayout) verticalLayout.getChildAt(1); // Récupérer chaque rowLayout

                                for (int k = 0; k < rowLayout2.getChildCount(); k++){
                                    View child = rowLayout2.getChildAt(k);
                                    if (child instanceof ImageView && !(child instanceof ImageButton)) {
                                        cptImageView++;
                                        if (cptImageView == 4){
                                            ImageView image = (ImageView) child;
                                            image.setImageResource(R.drawable.rouge);
                                        }

                                    }
                                }

                            }

//                            int cptImageView = 0;
//                            for (int k = 0; k < rowLayout.getChildCount(); k++){
//                                View child = rowLayout.getChildAt(k);
//                                if (child instanceof ImageView && !(child instanceof ImageButton)) {
//                                    cptImageView++;
//                                    if (cptImageView == 3){
//                                        ImageView image = (ImageView) child;
//                                        image.setImageResource(R.drawable.rouge);
//                                    }
//
//                                }
//                            }

                            //
//                            if (value == 0) {
//                                button.setImageResource(R.drawable.rouge);
//                                value = 1;
//                            } else {
//                                button.setImageResource(R.drawable.gris);
//                                value = 0;
//                            }
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
    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadcastReceiver);
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Arrêter et libérer les ressources de MediaPlayer lorsque l'activité est détruite
        mediaPlayer.stop();
        mediaPlayer.release();
    }
}




