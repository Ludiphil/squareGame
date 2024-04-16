package com.example.squaregame;

import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.squaregame.databinding.ActivityMainBinding;

import java.util.HashMap;


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
    int numLines = 5; // Nombre de lignes à afficher
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


                            for (int u =1; u<=38; u++){
                                if (u== 6 || u==17 || u ==28){
                                    u = u + 6;
                                }
                                ButtonForCode buttonCompare = buttonMap.get(u);
                                ButtonForCode buttonCompare2 = buttonMap.get(u+5);
                                ButtonForCode buttonCompare3 = buttonMap.get(u+6);
                                ButtonForCode buttonCompare4 = buttonMap.get(u+11);
                                int cptImageViewRow = 0;
                                int cptImageViewColumn= 0;
                                if (buttonCompare.isSelected() && buttonCompare2.isSelected() && buttonCompare3.isSelected() && buttonCompare4.isSelected()){
                                    if (u == 1 || u==12 || u==23||u==34){
                                        cptImageViewColumn = 1;
                                    }
                                    else if (u == 2 || u==13 || u==24||u==35){
                                        cptImageViewColumn = 2;
                                    }
                                    else if (u == 3 || u==14 || u==25||u==36){
                                        cptImageViewColumn = 3;
                                    }
                                    else if (u == 4 || u==15 || u==26||u==37){
                                        cptImageViewColumn = 4;
                                    }
                                    else if (u == 5 || u==16 || u==27||u==38){
                                        cptImageViewColumn = 5;
                                    }
                                    if (u >= 1 && u <= 9) {
                                        cptImageViewRow = 1;
                                    } else if (u >= 10 && u <= 19) {
                                        cptImageViewRow = 2;
                                    } else if (u >= 20 && u <= 29) {
                                        cptImageViewRow = 3;
                                    } else if (u >= 30 && u <= 39) {
                                        cptImageViewRow = 4;
                                    } else {

                                    }
                                    if (cptImageViewRow == 1){
                                        int cptImageView = 0;
                                        for (int k = 0; k < rowLayout.getChildCount(); k++){

                                            View child = rowLayout.getChildAt(k);
                                            if (child instanceof ImageView && !(child instanceof ImageButton)) {
                                                cptImageView ++;
                                                if(cptImageView == cptImageViewColumn){
                                                    ImageView image = (ImageView) child;
                                                    image.setImageResource(R.drawable.rouge);
                                                    break;
                                                }

                                            }
                                        }
                                    } else if (cptImageViewRow == 2) {
                                        int cptImageView = 0;
                                        LinearLayout rowLayout2 = (LinearLayout) verticalLayout.getChildAt(1);
                                        for (int k = 0; k < rowLayout2.getChildCount(); k++){

                                            View child = rowLayout2.getChildAt(k);
                                            if (child instanceof ImageView && !(child instanceof ImageButton)) {
                                                cptImageView ++;
                                                if(cptImageView == cptImageViewColumn){
                                                    ImageView image = (ImageView) child;
                                                    image.setImageResource(R.drawable.rouge);
                                                    break;
                                                }

                                            }
                                        }
                                    } else if (cptImageViewRow == 3) {
                                        int cptImageView = 0;
                                        LinearLayout rowLayout3 = (LinearLayout) verticalLayout.getChildAt(2);
                                        for (int k = 0; k < rowLayout3.getChildCount(); k++){

                                            View child = rowLayout3.getChildAt(k);
                                            if (child instanceof ImageView && !(child instanceof ImageButton)) {
                                                cptImageView ++;
                                                if(cptImageView == cptImageViewColumn){
                                                    ImageView image = (ImageView) child;
                                                    image.setImageResource(R.drawable.rouge);
                                                    break;
                                                }

                                            }
                                        }
                                    }else if (cptImageViewRow == 4) {
                                        int cptImageView = 0;
                                        LinearLayout rowLayout4 = (LinearLayout) verticalLayout.getChildAt(3);
                                        for (int k = 0; k < rowLayout4.getChildCount(); k++){

                                            View child = rowLayout4.getChildAt(k);
                                            if (child instanceof ImageView && !(child instanceof ImageButton)) {
                                                cptImageView ++;
                                                if(cptImageView == cptImageViewColumn){
                                                    ImageView image = (ImageView) child;
                                                    image.setImageResource(R.drawable.rouge);
                                                    break;
                                                }

                                            }
                                        }
                                    }
                                }
                            }
                        }
                    });
                }

            }

        }

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Joueur j = (Joueur) bundle.getSerializable("JOUEUR");
        binding.PlayerName1.setText("Nom du joueur 1 : "+j.getPlayerName1());
        binding.PlayerName2.setText("Nom du joueur 2 : "+j.getPlayerName2());
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



