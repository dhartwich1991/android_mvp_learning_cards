package com.jdapplications.learningcards;

import android.app.Application;
import android.content.Context;

import com.jdapplications.learningcards.injection.component.ApplicationComponent;
import com.jdapplications.learningcards.injection.component.DaggerApplicationComponent;
import com.jdapplications.learningcards.injection.module.ApplicationModule;

import timber.log.Timber;

/**
 * @author daniel.hartwich
 */
public class LearningCardsApplication extends Application {
    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    public static LearningCardsApplication get(Context context) {
        return (LearningCardsApplication) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        if (applicationComponent == null) {
            applicationComponent = DaggerApplicationComponent.builder()
                  .applicationModule(new ApplicationModule(this))
                  .build();
        }
        return applicationComponent;
    }

    //Used later on for testing.
    public void setComponnt(ApplicationComponent applicationComponent) {
        this.applicationComponent = applicationComponent;
    }
}
