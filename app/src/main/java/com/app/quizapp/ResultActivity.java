package com.app.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    TextView tvPlayerName, tvScore;
    Button btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvPlayerName = findViewById(R.id.tvPlayerName);
        tvScore = findViewById(R.id.tvScore);
        btnShare = findViewById(R.id.btnShare);
        String playerName = getIntent().getStringExtra("PLAYER_NAME");
        int score = getIntent().getIntExtra("SCORE", 0);
        tvPlayerName.setText(playerName);
        tvScore.setText(score + "/4");

        btnShare.setOnClickListener(v -> {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, playerName + " scored " + score + "/4 in the Quiz App! \n Go Download your Quiz App Now!");
            startActivity(Intent.createChooser(shareIntent, "Share your score with others via"));
        });
    }
}
