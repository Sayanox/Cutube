package com.example.cutube.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cutube.R;
import com.example.cutube.model.User;

public class MainActivity extends AppCompatActivity {
    TextView mGreetingText;
    EditText mNameInput;
    EditText mPwdInput;
    Button mLoginButton;
    User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGreetingText = findViewById(R.id.min_activity_textV);
        mNameInput = findViewById(R.id.min_activity_EditText);
        mPwdInput = findViewById(R.id.min_activity_EditTextPW);
        mLoginButton = findViewById(R.id.min_activity_login_btn);
        mUser = new User();

        mLoginButton.setEnabled(false);
        mPwdInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mLoginButton.setEnabled(s.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mLoginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // The user just clicked
                mUser.setFirstname(mNameInput.getText().toString());

                Intent gameActivity = new Intent(MainActivity.this, UrlActivity.class);
                startActivity(gameActivity);
            }


        });
    }
}