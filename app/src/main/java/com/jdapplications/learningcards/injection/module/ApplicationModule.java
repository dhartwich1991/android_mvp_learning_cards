package com.jdapplications.learningcards.injection.module;

import android.app.Application;
import android.content.Context;

import com.jdapplications.learningcards.data.remote.LearningCardService;
import com.jdapplications.learningcards.injection.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Provide Application level dependencies.
 *
 * @author daniel.hartwich
 */
@Module
public class ApplicationModule {
    protected final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    Application provideApplication() {
        return application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return application;
    }

    @Provides
    @Singleton
    LearningCardService provideLearningCardService() {
        return LearningCardService.Creator.newLearningCardService();
    }
}
