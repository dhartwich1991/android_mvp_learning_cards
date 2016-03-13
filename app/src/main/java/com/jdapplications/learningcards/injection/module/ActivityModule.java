package com.jdapplications.learningcards.injection.module;

import android.app.Activity;
import android.content.Context;

import com.jdapplications.learningcards.injection.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * @author daniel.hartwich
 */
@Module
public class ActivityModule {
    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    Activity provideActivity() {
        return activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return activity;
    }
}
