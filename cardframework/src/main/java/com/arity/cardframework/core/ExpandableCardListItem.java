package com.arity.cardframework.core;

import android.view.MotionEvent;
import android.view.View;

/**
 * Created by rkanl on 5/18/2016.
 */

public abstract class ExpandableCardListItem extends CardListItem {

    private boolean isListItemHasExpansion = false;
    private boolean isExpanded = false;

    public ExpandableCardListItem(View itemView, Card parentCard) {
        super(itemView, parentCard);
        itemView.setOnTouchListener(onTouchListener);
    }

    public abstract void populateListItemData(int position, ListObject listObject);

    public void setIsListItemHasExpansion(boolean isListItemHasExpansion) {
        this.isListItemHasExpansion = isListItemHasExpansion;
    }

    public boolean isListItemHasExpansion() {
        return isListItemHasExpansion;
    }

    public abstract void showExpandableView();

    public abstract void hideExpandableView();

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        private float startX;
        private float startY;
        private static final int CLICK_ACTION_THRESHHOLD = 10;

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    startX = event.getX();
                    startY = event.getY();
                    break;
                case MotionEvent.ACTION_UP: {
                    float endX = event.getX();
                    float endY = event.getY();
                    if (isAClick(startX, endX, startY, endY)) {
                        if (isExpanded) {
                            hideExpandableView();
                        } else {
                            showExpandableView();
                        }
                    }
                    break;
                }
                default:
                    return true;
            }
            return true;
        }

        private boolean isAClick(float startX, float endX, float startY, float endY) {
            float differenceX = Math.abs(startX - endX);
            float differenceY = Math.abs(startY - endY);
            if (differenceX > CLICK_ACTION_THRESHHOLD || differenceY > CLICK_ACTION_THRESHHOLD) {
                return false;
            }
            return true;
        }
    };
}
