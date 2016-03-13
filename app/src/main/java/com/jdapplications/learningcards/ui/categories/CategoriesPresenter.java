package com.jdapplications.learningcards.ui.categories;

import android.util.Log;

import com.jdapplications.learningcards.data.remote.LearningCardService;
import com.jdapplications.learningcards.ui.base.BasePresenter;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author daniel.hartwich
 */
public class CategoriesPresenter extends BasePresenter<CategoriesMvpView> {
    private Subscription subscription;
    private final LearningCardService learningCardService;

    @Inject
    public CategoriesPresenter(LearningCardService learningCardService) {
        this.learningCardService = learningCardService;
    }

    @Override
    public void attachView(CategoriesMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
        if (subscription != null) { subscription.unsubscribe(); }
    }

    public void loadCategories() {
        checkViewAttached();

        subscription = learningCardService.getAvailableCategories("1")
              .subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe(categories -> {
                  getMvpView().showCategories(categories);
                  Log.d("Error", categories.get(0).toString());
              }, Throwable::printStackTrace);
    }
}
