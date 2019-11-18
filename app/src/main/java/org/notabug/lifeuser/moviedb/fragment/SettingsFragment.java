
package org.notabug.lifeuser.moviedb.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;

import org.notabug.lifeuser.moviedb.R;
import org.notabug.lifeuser.moviedb.activity.SettingsActivity;
import org.notabug.lifeuser.moviedb.adapter.SectionsPagerAdapter;

public class SettingsFragment extends PreferenceFragment
        implements SharedPreferences.OnSharedPreferenceChangeListener {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);
    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences()
                .registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences()
                .unregisterOnSharedPreferenceChangeListener(this);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals(SectionsPagerAdapter.HIDE_MOVIES_PREFERENCE)
                || key.equals(SectionsPagerAdapter.HIDE_PERSON_PREFERENCE)
                || key.equals(SectionsPagerAdapter.HIDE_SAVED_PREFERENCE)
                || key.equals(SectionsPagerAdapter.HIDE_SERIES_PREFERENCE)) {
            ((SettingsActivity) getActivity()).mTabsPreferenceChanged = true;
        }
    }
}
