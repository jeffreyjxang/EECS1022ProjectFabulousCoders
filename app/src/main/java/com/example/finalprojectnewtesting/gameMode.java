package com.example.finalprojectnewtesting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.example.finalprojectnewtesting.GameSettings;
import com.example.finalprojectnewtesting.R;
import com.example.finalprojectnewtesting.gameplayView;

public class gameMode extends AppCompatActivity {
    private GameSettings game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_mode);
        Utilities util = new Utilities();
        util.deleteSharedPreferencestring("attempts", getApplicationContext());
        util.deleteSharedPreferencestring("mode", getApplicationContext());
    }

    public void button1(View v) {
        EditText userGuessBox = (EditText) findViewById(R.id.userAttemptNum);
        GameSettings game = new GameSettings(1, userGuessBox.getText().toString());
        Utilities util = new Utilities();
        util.saveToSharedPrefString("1", "mode",getApplicationContext());
        util.saveToSharedPrefString(userGuessBox.getText().toString(), "attempts",getApplicationContext());

            Intent i = new Intent(getApplicationContext(), gameplayView.class);
            startActivity(i);
    }

    public void button2(View v) {
        EditText userGuessBox = (EditText) findViewById(R.id.userAttemptNum);
        EditText userRange = (EditText) findViewById(R.id.userRange);
        Utilities util = new Utilities();
        util.saveToSharedPrefString("2", "mode",getApplicationContext());
        util.saveToSharedPrefString(userGuessBox.getText().toString(), "attempts",getApplicationContext());
        util.saveToSharedPrefString(userRange.getText().toString(), "attempts",getApplicationContext());
        if( TextUtils.isEmpty(userGuessBox.getText()) || TextUtils.isEmpty(userGuessBox.getText())){


        }else{
            Intent i = new Intent(getApplicationContext(), gameplayView.class);
            startActivity(i);
        }
    }
}