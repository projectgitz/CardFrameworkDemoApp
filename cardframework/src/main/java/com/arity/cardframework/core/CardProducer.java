package com.arity.cardframework.core;

import android.support.v7.widget.RecyclerView;

/**
 * Created by Santhosh on 3/14/2017.
 */

public abstract class CardProducer {

    public abstract Card getCard(int cardType, RecyclerView mRecyclerView);

}
