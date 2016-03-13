package com.jdapplications.learningcards.ui.answers;

import com.jdapplications.learningcards.data.remote.LearningCardService;
import com.jdapplications.learningcards.ui.base.BasePresenter;

import javax.inject.Inject;

import rx.Subscription;

/**
 * @author daniel.hartwich
 */
public class AnswersPresenter extends BasePresenter<AnswersMvpView>{
    private Subscription subscription;
    private final LearningCardService learningCardService;

    @Inject
    public AnswersPresenter(LearningCardService learningCardService) {
        this.learningCardService = learningCardService;
    }


    @Override
    public void attachView(AnswersMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
        if (subscription != null) { subscription.unsubscribe(); }
    }

    public void loadAnswers() {

    }
}
