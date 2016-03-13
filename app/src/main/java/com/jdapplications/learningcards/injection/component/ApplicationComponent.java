package com.jdapplications.learningcards.injection.component;

import android.app.Application;
import android.content.Context;

import com.jdapplications.learningcards.data.local.PreferenceHelper;
import com.jdapplications.learningcards.data.remote.LearningCardService;
import com.jdapplications.learningcards.injection.ApplicationContext;
import com.jdapplications.learningcards.injection.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author daniel.hartwich
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    @ApplicationContext Context context();
    Application application();
    LearningCardService learningCardService();
    PreferenceHelper preferenceHelper();
}
