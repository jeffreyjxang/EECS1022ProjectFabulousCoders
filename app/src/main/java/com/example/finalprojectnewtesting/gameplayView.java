package com.example.finalprojectnewtesting;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

        if (Integer.parseInt(mode) == 2) {
            System.out.println(mode + attempts);
            TextView attemptBox = (TextView) findViewById(R.id.attempts);
            TextView score = (TextView) findViewById(R.id.score);

            if (attemptBox.getText().toString().equals("") || attemptBox.getText().toString().equals(null)) {
                attemptBox.setText("0");
            } else {

                attemptBox.setText("" + (Integer.parseInt(attemptBox.getText().toString()) + 1));
            }

            if (Integer.parseInt(attemptBox.getText().toString()) <= Integer.parseInt(attempts)) {
                System.out.println("TESTING 2");
                EditText userGuessBox = (EditText) findViewById(R.id.userAttemptNum);
                int userGuess = Integer.parseInt(userGuessBox.getText().toString());


                int number = Integer.parseInt(prefs.getString("randomNum",""));
                System.out.println("NUMBER" + number);
                if (number == (userGuess)) {
                    //win popup
                    showDialogWin();
                    userGuessBox.setText("");
                    if (score.getText().toString().equals("") || score.getText().toString().equals(null)) {
                        attemptBox.setText("0");
                    } else {

                        score.setText("" + (Integer.parseInt(score.getText().toString()) + 1));
                    }
                } else {
                    System.out.println("TESTING 1");
                    System.out.println(attemptBox.getText().toString());
                    System.out.println(Integer.parseInt(attempts));
                    //lose popup

                    Toast.makeText(gameplayView.this,"Wrong number, try again",Toast.LENGTH_LONG).show();
                }
            } else {
                score.setText("0");
                attemptBox.setText("0");
                showDialog();
            }









        } else {
            EditText userGuessBox = (EditText) findViewById(R.id.userAttemptNum);
            int userGuess = Integer.parseInt(userGuessBox.getText().toString());

            TextView attemptBox = (TextView) findViewById(R.id.attempts);
            TextView score = (TextView) findViewById(R.id.score);

            int number = util.randNumGen(5);

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
                //lose popup                                                                                                            ddddd
                if (Integer.parseInt(attemptBox.getText().toString()) <= Integer.parseInt(attempts)) {
                    showDialog();
                }

            }
        }
    }

    private void showDialog(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.layout_custom_dialog);

        dialog.show();
    }

    public void yesButtonDialog1(View view) {
        Intent i = new Intent(this, gameMode.class);
        startActivity(i);
    }

    public void noButtonDialog1(View view) {
        Intent i = new Intent(this, gameMain.class);
        startActivity(i);
    }

    private void showDialogWin(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.layout_custom_dialog_win);

        dialog.show();
    }

    public void yesButtonDialog2(View view) {
        Intent i = new Intent(this, gameMode.class);
        startActivity(i);
    }

    public void noButtonDialog2(View view) {
        Intent i = new Intent(this, gameMain.class);
        startActivity(i);
    }
}