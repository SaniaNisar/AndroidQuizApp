package com.app.quizapp;

public class Question {
    private String text;
    private String[] options;
    private String answer;

    public Question(String text, String[] options, String answer) {
        this.text = text;
        this.options = options;
        this.answer = answer;
    }

    public String getText() {
        return text;
    }

    public String[] getOptions() {
        return options;
    }

    public String getAnswer() {
        return answer;
    }
}
