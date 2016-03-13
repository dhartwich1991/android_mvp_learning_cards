package com.jdapplications.learningcards.injection.component;

import com.jdapplications.learningcards.MainActivity;
import com.jdapplications.learningcards.injection.ActivityScope;
import com.jdapplications.learningcards.injection.module.ActivityModule;
import com.jdapplications.learningcards.ui.answers.AnswersActivity;
import com.jdapplications.learningcards.ui.categories.CategoriesActivity;
import com.jdapplications.learningcards.ui.categoryquestions.CategoryQuestionsActivity;

import dagger.Component;

/**
 * This component injects dependencies to all Activities across the application.
 *
 * @author daniel.hartwich
 */
@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);

    void inject(CategoriesActivity categoriesActivity);

    void inject(CategoryQuestionsActivity categoryQuestionsActivity);

    void inject(AnswersActivity answersActivity);
}
