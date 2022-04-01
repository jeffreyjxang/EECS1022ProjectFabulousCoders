package com.example.finalprojectnewtesting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.finalprojectnewtesting.ui.Covidview;

import java.util.HashSet;
import java.util.Set;

public class SignupView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupview);
    }

    public void signupButton(View v) {
        //Create set to store the user's data {password, email, name, top score}
        Set<String> set = new HashSet<String>();

        //Get the various TextBoxes from the XML
        EditText email = (EditText) findViewById(R.id.emailSignup);
        EditText password = (EditText) findViewById(R.id.passwordSignup);
        EditText name = (EditText) findViewById(R.id.userSignup);

        //Gather the Strings inside the TextBoxes
        String emailText = email.getText().toString();
        String passwordText = password.getText().toString();
        String nameText = name.getText().toString();

        //Setup SharedPreferences to store the data
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        System.out.println(prefs.getAll());
        //Checks if the email and password aren't empty and the email contains an @
        if ((!emailText.equals("") || !passwordText.equals("") || !nameText.equals("")) && emailText.contains("@")) {
            //Check if the email already exists in database
            if (prefs.contains(emailText)) {
                System.out.println("this email already exists");
            } else {
                //Add all variables to set
                set.add(nameText);
                set.add(passwordText);

                //Use utility method to add set to the database
                Utilities util = new Utilities();
                util.saveToSharedPrefStringSet(set, emailText, getApplicationContext());
                System.out.println("accoutn added");

                //Switch Activity
                Intent i = new Intent(this, gameMain.class);
                startActivity(i);
            }
        }
    }
}