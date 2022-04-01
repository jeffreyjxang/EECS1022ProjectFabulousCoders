package com.example.finalprojectnewtesting.ui;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.TextView;

import com.example.finalprojectnewtesting.Background;
import com.example.finalprojectnewtesting.R;

public class Covidview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covidview);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        //Initialize Covid Page when App Starts
        initCovid();

    }

    public void initCovid() {
        //Gather Covid Information from API --> https://api.opencovid.ca/
        Background bg = new Background(getApplicationContext());
        bg.doInBackground();

        //Setup SharedPreferences
        SharedPreferences prefs = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);

        //Get the various TextBoxes from the XML
        TextView affectText = (TextView) findViewById(R.id.affectedCases);
        TextView deathsText = (TextView) findViewById(R.id.deathCases);
        TextView recoverText = (TextView) findViewById(R.id.recoveredCases);
        TextView activeText = (TextView) findViewById(R.id.activeCases);

        //Set the value of the TextBoxes on the XML with the ones from SharedPreferences
        affectText.setText(prefs.getString("affected", ""));
        deathsText.setText(prefs.getString("deaths", ""));
        recoverText.setText(prefs.getString("recovered", ""));
        activeText.setText(prefs.getString("active", ""));
    }
}