package com.example.finalprojectnewtesting;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class Utilities {

    public void saveToSharedPrefString(String value, String name, Context context) {
        SharedPreferences prefs = context.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(name, value);
        editor.commit();
    }
    public void saveToSharedPrefStringSet(Set<String> value, String name, Context context) {
        SharedPreferences prefs = context.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putStringSet(name, value);
        editor.commit();
    }

    public int randNumGen(int range) {
        return (int) (1 + Math.random() * range);
    }

    public void deleteSharedPreferencestring(String name, Context context) {
        SharedPreferences prefs = context.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.remove(name);
        editor.commit();
    }
}
