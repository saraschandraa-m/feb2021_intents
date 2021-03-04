package com.nextstacks.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText mEtPhoneNumber = findViewById(R.id.et_phone_number);
        EditText mEtEmailAddress = findViewById(R.id.et_email_address);
        EditText mEtEmailSubject = findViewById(R.id.et_email_subject);
        EditText mEtEmailMessage = findViewById(R.id.et_email_message);

        Button mBtnCall = findViewById(R.id.btn_call);
        Button mBtnOpenBrowser = findViewById(R.id.btn_open_browser);
        Button mBtnSendEmail = findViewById(R.id.btn_send_email);

        mBtnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = mEtPhoneNumber.getText().toString();

                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + phoneNumber));
                startActivity(callIntent);
            }
        });

        mBtnOpenBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("https://nextstacks.com"));
                startActivity(browserIntent);
            }
        });


        mBtnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailAddress = mEtEmailAddress.getText().toString();
                String emailSubject = mEtEmailSubject.getText().toString();
                String emailMessage = mEtEmailMessage.getText().toString();

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
                emailIntent.putExtra(Intent.EXTRA_TEXT, emailMessage);
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailAddress});
                emailIntent.setType("message/rfc822");
                startActivity(emailIntent);
            }
        });

    }
}