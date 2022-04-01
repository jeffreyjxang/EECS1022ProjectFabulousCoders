package com.example.finalprojectnewtesting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.finalprojectnewtesting.ui.Covidview;

public class LoginView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginview);
    }

    public void loginButton(View v) {
        //Get the various TextBoxes from the XML
        EditText email = (EditText) findViewById(R.id.emailLogin);
        EditText password = (EditText) findViewById(R.id.passwordLogin);

        //Gather the Strings inside the TextBoxes
        String emailText = email.getText().toString();
        String passwordText = password.getText().toString();

        //Setup SharedPreferences
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
        System.out.println(prefs.getAll());
        //Check if the email already exists inside database
        if (prefs.contains(emailText)){
            //Checks if the password matches the one in the database
            if (String.valueOf(prefs.getStringSet(emailText, null).toArray()[1]).equals(passwordText) ||
                    String.valueOf(prefs.getStringSet(emailText, null).toArray()[0]).equals(passwordText)
            ) {
                System.out.println("logged in");
                //Changes Activity
                Intent i = new Intent(this, gameMain.class);
                startActivity(i);
            } else {
                System.out.println("wrong pass");
            }
        }
    }

    //Changes Activity to the Signup Screen
    public void signUpButton(View v) {
        Intent i = new Intent(this, SignupView.class);
        startActivity(i);
    }

}