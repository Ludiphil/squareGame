package com.example.squaregame;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.squaregame.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
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

                            for (int u =1; u<=49; u++){
                                if (u== 6 || u==17 || u ==28 || u ==39){
                                    u = u + 6;
                                }
                                ButtonForCode buttonCompare = buttonMap.get(u);
                                ButtonForCode buttonCompare2 = buttonMap.get(u+5);
                                ButtonForCode buttonCompare3 = buttonMap.get(u+6);
                                ButtonForCode buttonCompare4 = buttonMap.get(u+11);
                                int cptImageViewRow = 0;
                                int cptImageViewColumn= 0;
                                if (buttonCompare.isSelected() && buttonCompare2.isSelected() && buttonCompare3.isSelected() && buttonCompare4.isSelected()){
                                    if (u == 1 || u==12 || u==23||u==34||u==45){
                                        cptImageViewColumn = 1;
                                    }
                                    else if (u == 2 || u==13 || u==24||u==35||u==46){
                                        cptImageViewColumn = 2;
                                    }
                                    else if (u == 3 || u==14 || u==25||u==36||u==47){
                                        cptImageViewColumn = 3;
                                    }
                                    else if (u == 4 || u==15 || u==26||u==37||u==48){
                                        cptImageViewColumn = 4;
                                    }
                                    else if (u == 5 || u==16 || u==27||u==38||u==49){
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
                                    } else if (u >= 40 && u <= 49) {
                                        cptImageViewRow = 5;
                                    } else {
                                        System.out.println("Le nombre n'appartient à aucune tranche spécifique.");
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
                                    } else if (cptImageViewRow == 5) {
                                        int cptImageView = 0;
                                        LinearLayout rowLayout5 = (LinearLayout) verticalLayout.getChildAt(4);
                                        for (int k = 0; k < rowLayout5.getChildCount(); k++){

                                            View child = rowLayout5.getChildAt(k);
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




