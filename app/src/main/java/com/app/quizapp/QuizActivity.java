package com.app.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class QuizActivity extends AppCompatActivity {
    String playerName;
    ImageButton btnPrevious;
    TextView tvQuestion, tvProgress;
    int currentQuesIndex = 0, score = 0;
    List<Question> questions;
    int[] selectedAnswers;
    RadioGroup rgOptions;
    RadioButton rbOption1, rbOption2, rbOption3, rbOption4;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        playerName = getIntent().getStringExtra("PLAYER_NAME");

        tvQuestion = findViewById(R.id.tvQuestion);
        tvProgress = findViewById(R.id.tvProgress);
        rgOptions = findViewById(R.id.rgOptions);
        rbOption1 = findViewById(R.id.rbOption1);
        rbOption2 = findViewById(R.id.rbOption2);
        rbOption3 = findViewById(R.id.rbOption3);
        rbOption4 = findViewById(R.id.rbOption4);
        btnNext = findViewById(R.id.btnNext);
        btnPrevious = findViewById(R.id.btnPrevious);

        questions = QuestionBank.getQuestions();
        selectedAnswers = new int[questions.size()];
        Arrays.fill(selectedAnswers, -1);

        loadQuestion();
        btnNext.setOnClickListener(v -> {
            saveAnswer();
            if (currentQuesIndex < questions.size() - 1) {
                currentQuesIndex++;
                loadQuestion();
            } else {
                calculateScore();
                Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                intent.putExtra("PLAYER_NAME", playerName);
                intent.putExtra("SCORE", score);
                startActivity(intent);
                finish();
            }
        });

        btnPrevious.setOnClickListener(v -> {
            if (currentQuesIndex > 0) {
                saveAnswer();
                currentQuesIndex--;
                loadQuestion();
            }
        });
    }
    void loadQuestion() {
        Question q = questions.get(currentQuesIndex);
        tvProgress.setText((currentQuesIndex + 1) + "/" + questions.size());
        tvQuestion.setText(q.getText());
        rbOption1.setText(q.getOptions()[0]);
        rbOption2.setText(q.getOptions()[1]);
        rbOption3.setText(q.getOptions()[2]);
        rbOption4.setText(q.getOptions()[3]);

        rgOptions.clearCheck();
        if (selectedAnswers[currentQuesIndex] != -1) {
            ((RadioButton) rgOptions.getChildAt(selectedAnswers[currentQuesIndex])).setChecked(true);
        }
        btnNext.setText(currentQuesIndex == questions.size() - 1 ? "Finish" : "Next");
        btnPrevious.setVisibility(currentQuesIndex == 0 ? View.INVISIBLE : View.VISIBLE);
    }
    void saveAnswer() {
        int selectedId = rgOptions.getCheckedRadioButtonId();
        if (selectedId != -1) {
            View selectedView = findViewById(selectedId);
            int answerIndex = rgOptions.indexOfChild(selectedView);

            if (answerIndex != -1) {
                selectedAnswers[currentQuesIndex] = answerIndex;
            }
        }
    }
    void calculateScore() {
        score = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (selectedAnswers[i] != -1 &&
                    questions.get(i).getOptions()[selectedAnswers[i]].equals(questions.get(i).getAnswer())) {
                score++;
            }
        }
    }
}
