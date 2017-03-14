package com.arity.cardframework.core;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by rkanl on 5/26/2016.
 */
public class CardInnerRecyclerView extends RecyclerView {
    public CardInnerRecyclerView(Context context) {
        super(context);
    }

    public CardInnerRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CardInnerRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        final int action = ev.getAction();
        final int actionMasked = action & MotionEvent.ACTION_MASK;
        switch (actionMasked) {
            case MotionEvent.ACTION_DOWN:
                return super.dispatchTouchEvent(ev);
            case MotionEvent.ACTION_MOVE:
                return true;
            case MotionEvent.ACTION_CANCEL:
                return true;
            case MotionEvent.ACTION_UP:
                return super.dispatchTouchEvent(ev);
            default:
                return super.dispatchTouchEvent(ev);
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        final int action = e.getAction();
        final int actionMasked = action & MotionEvent.ACTION_MASK;
        if (actionMasked == MotionEvent.ACTION_DOWN) {
            return false; //intercepted by the viewgroup and passed down to child
        } else if (actionMasked == MotionEvent.ACTION_UP) {
            return false; //intercepted by the viewgroup and passed down to child
        }
        return super.onInterceptTouchEvent(e);
    }
}
