package com.example.train.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.train.R;
import com.example.train.model.Question;
import com.example.train.model.QuestionBank;
import com.example.train.model.User;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    TextView mGreetingText;
    EditText mNameInput;
    Button mPlayButton;
    User mUser;
    //QuestionBank mQuestionBank;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGreetingText = findViewById(R.id.min_activity_textV);
        mNameInput = findViewById(R.id.min_activity_EditText);
        mPlayButton = findViewById(R.id.min_activity_play_btn);
        mUser = new User();
        //mQuestionBank = this.generateQuestions();
        mPlayButton.setEnabled(false);
        mNameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPlayButton.setEnabled(s.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mPlayButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // The user just clicked
                mUser.setFirstname(mNameInput.getText().toString());

                Intent gameActivity = new Intent(MainActivity.this, GameActvity.class);
                startActivity(gameActivity);
            }


        });

        
    }




}