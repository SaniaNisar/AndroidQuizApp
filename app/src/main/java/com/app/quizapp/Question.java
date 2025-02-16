package com.app.quizapp;

public class Question {
    private String qtext, qanswer;
    private final String[] options;
    public Question(String text, String[] options, String answer) {
        this.qtext = text;
        this.options = options;
        this.qanswer = answer;
    }
    public String getText() {
        return qtext;
    }
    public String getAnswer() {
        return qanswer;
    }
    public String[] getOptions() {
        return options;
    }
}
