package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        DisplaySavedText();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredText = editText.getText().toString();

                DisplayAndSaveText(enteredText);
            }
        });
    }

    private void DisplayAndSaveText(String enteredText) {
        textView.setText(enteredText);

        SharedPreferences sharedPreferences = getSharedPreferences(
                "My shared preferences",
                MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("name", enteredText);
        editor.apply();


    }

    private void DisplaySavedText() {
        SharedPreferences sharedPreferences = getSharedPreferences(
                "My shared preferences",
                MODE_PRIVATE
        );

        String s1 = sharedPreferences.getString(
                "name",
                "isEmpty");
        textView.setText(s1);
    }

}