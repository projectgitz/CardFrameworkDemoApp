package com.arity.cardframeworkdemoapp;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;

import com.arity.cardframework.core.Card;
import com.arity.cardframework.core.CardProducer;

/**
 * Created by Santhosh on 3/14/2017.
 */

public class MyCardProducer extends CardProducer {

    @Override
    public Card getCard(int cardType, RecyclerView mRecyclerView) {
        Card card;
        LayoutInflater inflater = LayoutInflater.from(mRecyclerView.getContext());
        switch (cardType) {
            case CardType.SAMPLE_BASE_LAYOUT:
                card = new SampleBaseCard(inflater.inflate(R.layout.card_base_layout, null));
                break;
            default:
                throw new IllegalArgumentException("Invalid Card Type");
        }
        if (card != null) {
            card.setCardType(cardType);
        }
        return card;
    }
}
