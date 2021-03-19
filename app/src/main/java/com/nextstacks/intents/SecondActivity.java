package com.nextstacks.intents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView mTvUsername;
    private TextView mTvEmailAddress;

    private String username;
    private String emailaddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mTvUsername = findViewById(R.id.tv_username);
        mTvEmailAddress = findViewById(R.id.tv_email_address);

        Bundle data = getIntent().getExtras();

        if (data != null) {
            username = data.getString("username");
            emailaddress = data.getString("emailaddress");

            mTvUsername.setText(username);
            mTvEmailAddress.setText(emailaddress);
        }

        Button btnEditUsername = findViewById(R.id.btnEditusername);
        Button btnEditEmailAddress = findViewById(R.id.btnEditEmailAddress);

        btnEditUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent editIntent = new Intent(SecondActivity.this, EditActivity.class);
                editIntent.putExtra("edit_value", username);
                startActivityForResult(editIntent, 1001);
            }
        });

        btnEditEmailAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent editIntent = new Intent(SecondActivity.this, EditActivity.class);
                editIntent.putExtra("edit_value", emailaddress);
                startActivityForResult(editIntent, 1002);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1001) {
            if (resultCode == Activity.RESULT_OK) {
                username = data.getExtras().getString("edited_value");
                mTvUsername.setText(username);
            }
        }else if(requestCode == 1002){
            if(resultCode == Activity.RESULT_OK){
                emailaddress = data.getExtras().getString("edited_value");
                mTvEmailAddress.setText(emailaddress);
            }
        }
    }
}