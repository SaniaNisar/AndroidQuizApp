package com.app.quizapp;

import java.util.ArrayList;
import java.util.List;

public class QuestionBank {
    public static List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the name of SMD Teacher Assistant?",
                new String[]{"Umera Javed", "Faraz Shakeel", "Tayyab Anees", "Robina Zohaib"}, "Tayyab Anees"));
        questions.add(new Question("What is the deadline for submission of Assignment 1?",
                new String[]{"12am", "12pm", "11:59am", "11:59pm"}, "11:59pm"));
        questions.add(new Question("Which Language should we have to use for this assignment?",
                new String[]{"Python", "Java", "Flutter", "C++"}, "Java"));
        questions.add(new Question("What do we have to make in this assignment?",
                new String[]{"A Quiz App", "A Recipe Finder App", "A Movie Streaming App", "Tic Tac Toe Game"}, "A Quiz App"));
        return questions;
    }
}
