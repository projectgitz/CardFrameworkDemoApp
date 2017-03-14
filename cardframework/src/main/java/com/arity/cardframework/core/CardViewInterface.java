package com.arity.cardframework.core;

/**
 * Created by rkanl on 3/31/2016.
 */
public interface CardViewInterface {

    void showProgress();

    void hideProgress();

    void onSessionError(boolean showErrorCard);
}
