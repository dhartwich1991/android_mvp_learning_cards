package com.jdapplications.learningcards.ui.categoryquestions;

import com.jdapplications.learningcards.data.remote.LearningCardService;
import com.jdapplications.learningcards.ui.base.BasePresenter;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author daniel.hartwich
 */
public class CategoryQuestionsPresenter extends BasePresenter<CategoryQuestionsMvpView> {
    private final LearningCardService learningCardService;
    private Subscription subscription;

    @Inject
    public CategoryQuestionsPresenter(LearningCardService learningCardService) {
        this.learningCardService = learningCardService;
    }

    @Override
    public void attachView(CategoryQuestionsMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
        if (subscription != null) { subscription.unsubscribe(); }
    }

    public void loadQuestions(String categoryId) {
        checkViewAttached();
        subscription = learningCardService.getAllQuestionsFromCategory(categoryId)
              .subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe(categoryQuestions -> {
                  getMvpView().showQuestions(categoryQuestions);
              }, Throwable::printStackTrace);
    }
}
