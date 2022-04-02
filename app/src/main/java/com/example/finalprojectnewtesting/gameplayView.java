package com.example.finalprojectnewtesting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class gameplayView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay_view);
    }

    public void button2(View v) {

        SharedPreferences prefs = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);

        String mode = prefs.getString("mode", "");
        String attempts = prefs.getString("attempts", "");

        Utilities util = new Utilities();

        if (Integer.parseInt(mode) == 1) {
            System.out.println(mode + attempts);
            TextView attemptBox = (TextView) findViewById(R.id.attempts);
            TextView score = (TextView) findViewById(R.id.score);

            if (attemptBox.getText().toString().equals("") || attemptBox.getText().toString().equals(null)) {
                attemptBox.setText("0");
            } else {

                attemptBox.setText("" + (Integer.parseInt(attemptBox.getText().toString()) + 1));
            }

            if (Integer.parseInt(attemptBox.getText().toString()) < Integer.parseInt(attempts)) {
                EditText userGuessBox = (EditText) findViewById(R.id.userAttemptNum);
                int userGuess = Integer.parseInt(userGuessBox.getText().toString());


                int number = util.randNumGen(0);
                System.out.println(number);
                if (number == (userGuess)) {
                    //win popup
                    userGuessBox.setText("");
                    if (score.getText().toString().equals("") || score.getText().toString().equals(null)) {
                        attemptBox.setText("0");
                    } else {

                        score.setText("" + (Integer.parseInt(score.getText().toString()) + 1));
                    }
                } else {

                    score.setText("0");
                    attemptBox.setText("0");
                    //lose popup

                    Intent i = new Intent(this, gameMain.class);
                    startActivity(i);
                }
            } else {
                score.setText("0");
                attemptBox.setText("0");

                Intent i = new Intent(this, gameMain.class);
                startActivity(i);
            }
        } else {
            System.out.println(mode + attempts);
            TextView attemptBox = (TextView) findViewById(R.id.attempts);
            TextView score = (TextView) findViewById(R.id.score);

            if (attemptBox.getText().toString().equals("") || attemptBox.getText().toString().equals(null)) {
                attemptBox.setText("0");
            } else {

                attemptBox.setText("" + (Integer.parseInt(attemptBox.getText().toString()) + 1));
            }

            if (Integer.parseInt(attemptBox.getText().toString()) < Integer.parseInt(attempts)) {
                EditText userGuessBox = (EditText) findViewById(R.id.userAttemptNum);
                int userGuess = Integer.parseInt(userGuessBox.getText().toString());

                int number = util.randNumGen(0);
                System.out.println(number);
                if (number == (userGuess)) {
                    //win popup
                    userGuessBox.setText("");
                    if (score.getText().toString().equals("") || score.getText().toString().equals(null)) {
                        attemptBox.setText("0");
                    } else {

                        score.setText("" + (Integer.parseInt(score.getText().toString()) + 1));
                    }
                } else {
                    //lose popup

                    Intent i = new Intent(this, gameMain.class);
                    startActivity(i);
                }
            } else {
                Intent i = new Intent(this, gameMain.class);
                startActivity(i);
            }
        }

    }
}