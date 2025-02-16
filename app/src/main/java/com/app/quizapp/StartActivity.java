package com.app.quizapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {
    EditText etName;
    Button btnStart;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        etName = findViewById(R.id.etName);
        btnStart = findViewById(R.id.btnStart);
        sharedPreferences = getSharedPreferences("QuizAppPrefs", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("PLAYER_NAME");
        editor.apply();

        btnStart.setOnClickListener(view -> {
            String name = etName.getText().toString().trim();

            // Check if name is empty
            if (name.isEmpty()) {
                Toast.makeText(StartActivity.this, "Please enter your name!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Save name in SharedPreferences
            editor.putString("PLAYER_NAME", name);
            editor.apply();

            // Start QuizActivity and pass name
            Intent intent = new Intent(StartActivity.this, QuizActivity.class);
            intent.putExtra("PLAYER_NAME", name);
            startActivity(intent);
        });
    }
}
