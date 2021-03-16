package com.nextstacks.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ExplicitIntentActivity extends AppCompatActivity {

    private EditText mEtUsername;
    private EditText mEtEmailAddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intent);


        mEtUsername = findViewById(R.id.et_user_name);
        mEtEmailAddress = findViewById(R.id.et_email_addresss);
    }

    public void onMoveToSecondClicked(View view) {
//        mEtUsername.getText().toString();
        String username = mEtUsername.getText().toString();
        String email = mEtEmailAddress.getText().toString();

        Intent secondIntent = new Intent(ExplicitIntentActivity.this, SecondActivity.class);
        secondIntent.putExtra("username", username);
        secondIntent.putExtra("emailaddress", email);
        startActivity(secondIntent);
    }
}