package com.nextstacks.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView mTvUsername = findViewById(R.id.tv_username);
        TextView mTvEmailAddress = findViewById(R.id.tv_email_address);

        Bundle data = getIntent().getExtras();

        if(data != null){
            String username = data.getString("username");
            String emailaddress = data.getString("emailaddress");

            mTvUsername.setText(username);
            mTvEmailAddress.setText(emailaddress);
        }
    }
}