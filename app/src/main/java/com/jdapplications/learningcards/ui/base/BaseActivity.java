package com.jdapplications.learningcards.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jdapplications.learningcards.LearningCardsApplication;
import com.jdapplications.learningcards.injection.component.ActivityComponent;
import com.jdapplications.learningcards.injection.component.DaggerActivityComponent;
import com.jdapplications.learningcards.injection.module.ActivityModule;

/**
 * @author daniel.hartwich
 */
public class BaseActivity extends AppCompatActivity {
    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = DaggerActivityComponent.builder()
                  .activityModule(new ActivityModule(this))
                  .applicationComponent(LearningCardsApplication.get(this).getComponent())
                  .build();
        }
        return activityComponent;
    }
}
