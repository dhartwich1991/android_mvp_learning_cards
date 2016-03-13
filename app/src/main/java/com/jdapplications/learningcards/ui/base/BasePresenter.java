package com.jdapplications.learningcards.ui.base;

/**
 * Base class that implement the Presenter interface and provides a base implementation for attachView() and detachView().
 * It also handles keeping a reference to the mvpView that can be accessed from the children classes by calling
 * getMvpView().
 *
 * @author daniel.hartwich
 */
public class BasePresenter<T extends MvpView> implements Presenter<T> {
    private T mvpView;

    @Override
    public void attachView(T mvpView) {
        this.mvpView = mvpView;
    }

    @Override
    public void detachView() {
        mvpView = null;
    }

    public boolean isViewAttached() {
        return mvpView != null;
    }

    public T getMvpView() {
        return mvpView;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) { throw new MvpViewNotAttachedException(); }
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        private static final long serialVersionUID = 8937083835263109712L;
        public MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(MvpView) before requesting data to the Presenter.");
        }
    }
}
