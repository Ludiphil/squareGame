package com.example.squaregame;

import android.content.Context;
import android.content.SharedPreferences;

public class GamePreferences {
    private static final String PREF_NAME = "GamePrefs";
    private static final String KEY_BEST_SCORE = "best_score";
    private static final String KEY_BEST_PLAYER_NAME = "best_player_name";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public GamePreferences(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveBestScore(int score, String playerName) {
        editor.putInt(KEY_BEST_SCORE, score);
        editor.putString(KEY_BEST_PLAYER_NAME, playerName);
        editor.apply();
    }

    public int getBestScore() {
        return sharedPreferences.getInt(KEY_BEST_SCORE, 0);
    }

    public String getBestPlayerName() {
        return sharedPreferences.getString(KEY_BEST_PLAYER_NAME, "");

    }
}
