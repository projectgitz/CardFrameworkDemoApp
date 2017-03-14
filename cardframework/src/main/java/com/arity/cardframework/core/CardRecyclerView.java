package com.arity.cardframework.core;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by rkanl on 3/30/2016.
 */
public class CardRecyclerView extends RecyclerView {

    public CardRecyclerView(Context context) {
        super(context);
        init();
    }

    public CardRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CardRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        WrapContentLinearLayoutManager layoutManager = new WrapContentLinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        setLayoutManager(layoutManager);
        setItemViewCacheSize(20);
    }
}
