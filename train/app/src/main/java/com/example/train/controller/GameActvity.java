package com.example.train.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.train.R;
import com.example.train.model.Question;
import com.example.train.model.QuestionBank;

import java.util.Arrays;

public class GameActvity extends AppCompatActivity {
    private TextView gMainText;
    private Button mBT1,mBT2,mBT3,mBT4;
    private Question mCurrentQuestion;
    private QuestionBank mQuestionBank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        gMainText = findViewById(R.id.min_activity_textV);
        mBT1 = findViewById(R.id.activity_game_answer1_btn);
        //gMainText.setText();
        //mBT1.setEnabled(true);
    }
    private QuestionBank generateQuestions(){
        Question question1 = new Question("Who is the creator of Android?",
                Arrays.asList("Andy Rubin",
                        "Steve Wozniak",
                        "Jake Wharton",
                        "Paul Smith"),
                0);

        Question question2 = new Question("When did the first man land on the moon?",
                Arrays.asList("1958",
                        "1962",
                        "1967",
                        "1969"),
                3);

        Question question3 = new Question("What is the house number of The Simpsons?",
                Arrays.asList("42",
                        "101",
                        "666",
                        "742"),
                3);

        return new QuestionBank(Arrays.asList(question1,
                question2,
                question3));
    }
}