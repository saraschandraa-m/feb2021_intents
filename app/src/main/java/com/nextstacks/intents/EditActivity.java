package com.nextstacks.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        EditText mEtEditField = findViewById(R.id.etEditField);
        Button btnEditOk = findViewById(R.id.btnEditOk);
        Button btnEditCancel = findViewById(R.id.btnEditCancel);

        Bundle data = getIntent().getExtras();

        String editValue = data.getString("edit_value");

        mEtEditField.setText(editValue);

        btnEditCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        btnEditOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String editedValue = mEtEditField.getText().toString();

                Intent returnIntent = new Intent();
                returnIntent.putExtra("edited_value", editedValue);
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });


    }
}