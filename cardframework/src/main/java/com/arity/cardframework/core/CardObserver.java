package com.arity.cardframework.core;

import android.os.Bundle;

/**
 * Created by rkanl on 6/16/2016.
 */
public interface CardObserver {
    void onScroll();

    void onResume();

    void onPause();

    void onCreate(Bundle savedInstanceState);

    void onDestroy();

    void setCardObservable(CardObservable cardObservable);
}
