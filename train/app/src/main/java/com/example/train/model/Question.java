package com.example.train.model;

import java.util.List;

public class Question {
    private String mQuestion;
    private List<String> mChoiceList;
    private int mAnswerIndex;

    public Question(String s, List<String> asList, int i) {
        mQuestion=s;
        mChoiceList=asList;
        mAnswerIndex=i;
    }
}
