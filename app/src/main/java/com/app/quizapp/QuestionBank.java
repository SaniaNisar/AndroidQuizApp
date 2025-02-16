package com.app.quizapp;

import java.util.ArrayList;
import java.util.List;

public class QuestionBank {
    public static List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?",
                new String[]{"Paris", "London", "Berlin", "Madrid"}, "Paris"));
        questions.add(new Question("Who developed Java?",
                new String[]{"Microsoft", "Sun Microsystems", "Apple", "Google"}, "Sun Microsystems"));
        questions.add(new Question("Which planet is known as the Red Planet?",
                new String[]{"Earth", "Venus", "Mars", "Jupiter"}, "Mars"));
        questions.add(new Question("What is the largest ocean on Earth?",
                new String[]{"Atlantic Ocean", "Indian Ocean", "Pacific Ocean", "Arctic Ocean"}, "Pacific Ocean"));
        return questions;
    }
}
