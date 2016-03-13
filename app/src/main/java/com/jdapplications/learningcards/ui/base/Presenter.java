package com.jdapplications.learningcards.ui.base;

/**
 * Every presenter in the app must either implement this interface or extend BasePresenter indicating the MvpView type
 * that wants to be attached with.
 *
 * @author daniel.hartwich
 */
public interface Presenter<V extends MvpView> {
    void attachView(V mvpView);

    void detachView();
}
