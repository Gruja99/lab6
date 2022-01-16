package com.example.lab_6;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

import com.example.lab_6.R;

public class AppPreferenceActivity extends PreferenceActivity{
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
PreferenceManager preferenceManager = getPreferenceManager();
preferenceManager.setSharedPreferencesName("appPreferences");

        addPreferencesFromResource(R.xml.myapppreferences);
    }
}
