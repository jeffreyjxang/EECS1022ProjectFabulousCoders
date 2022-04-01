package com.example.finalprojectnewtesting;

import android.content.SharedPreferences;
import android.content.Context;
import android.os.AsyncTask;
import android.preference.PreferenceManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Background extends AsyncTask<Integer,Void,String>{

    private Context context;

    public Background(Context context) {
        this.context = context;
    }

    @Override
    public String doInBackground(Integer... params) {
        //Instantiate Covid Object
        CovidStats covid = new CovidStats();
        //Instantiate Utility Class
        Utilities util = new Utilities();
        try {
            //Get the information from the API
            URL url = new URL("https://api.opencovid.ca/");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;

            //Splitting the data from the API into strings
            while ((line = in.readLine()) != null) {
                String[] wholeValues = line.split(",");

                covid.setAffected(wholeValues[5].split(":")[1]);
                covid.setDeath(wholeValues[7].split(":")[1].split("\\.")[0]);
                covid.setRecovered(wholeValues[9].split(":")[1].split("\\.")[0]);
                covid.setActive(wholeValues[0].split(":")[2]);

                //Saving the strings into SharedPreferences using utility methods
                SharedPreferences prefs = context.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                util.saveToSharedPrefString(covid.getAffected(),"affected",context);
                util.saveToSharedPrefString(covid.getDeath(),"deaths",context);
                util.saveToSharedPrefString(covid.getRecovered(),"recovered",context);
                util.saveToSharedPrefString(covid.getActive(),"active",context);
                editor.commit();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}