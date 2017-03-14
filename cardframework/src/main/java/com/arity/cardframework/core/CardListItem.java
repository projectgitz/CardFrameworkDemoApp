package com.arity.cardframework.core;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by rkanl on 4/7/2016.
 */
public abstract class CardListItem extends RecyclerView.ViewHolder {

    private Card parentCard;

    public CardListItem(View itemView, Card parentCard) {
        super(itemView);
        this.parentCard = parentCard;
    }

    public Card getParentCard() {
        return parentCard;
    }

    public abstract void populateListItemData(int position, ListObject listObject);

}
