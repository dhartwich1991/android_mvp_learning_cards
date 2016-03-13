package com.jdapplications.learningcards.data.local;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import com.jdapplications.learningcards.injection.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author daniel.hartwich
 */
@Singleton
public class PreferenceHelper {

    public static final String PREF_FILE_NAME = "learning_cards_pref_file";
    public static final String USER_ID = "USER_ID";

    private final SharedPreferences prefs;

    @Inject
    public PreferenceHelper(@ApplicationContext Context context) {
        prefs = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
    }

    public void setUserId(String userId) {
        prefs.edit().putString(USER_ID, userId).apply();
    }

    @Nullable
    public String userId() {
        return prefs.getString(USER_ID, null);
    }

    public void clear() {
        prefs.edit().clear().apply();
    }
}
