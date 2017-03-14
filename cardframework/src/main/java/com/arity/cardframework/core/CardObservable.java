package com.arity.cardframework.core;

import android.os.Bundle;

/**
 * Created by rkanl on 6/16/2016.
 */
public interface CardObservable {

    void registerScrollObserver(CardObserver cardObserver);

    void unregisterScrollObserver(CardObserver cardObserver);

    void notifyOnScroll();

    void notifyOnResume();

    void notifyOnPause();

    void notifyOnCreate(Bundle savedInstanceState);

    void notifyOnDestroy();
}
