package com.arity.cardframework.core;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by rkanl on 3/30/2016.
 */
public class CardAdapter extends RecyclerView.Adapter<Card> {

    private static final String TAG = CardAdapter.class.getSimpleName();
    private final CardProducer cardProducer;
    private List<Integer> cardsTypes;
    private RecyclerView cardRecyclerView;

    public CardAdapter(List<Integer> types,CardProducer cardProducer) {
        this.cardsTypes = types;
        this.cardProducer=cardProducer;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        cardRecyclerView = recyclerView;
    }

    public void onViewRecycled(Card holder) {
        super.onViewRecycled(holder);
        holder.onCardDetachedFromWindow();
    }

    @Override
    public Card onCreateViewHolder(ViewGroup parent, int viewType) {
        Card card = cardProducer.getCard(viewType,cardRecyclerView);
        card.onCardAttachedToWindow();
        return card;
    }

    @Override
    public void onBindViewHolder(Card holder, int position) {
    }

    @Override
    public int getItemCount() {
        return cardsTypes.size();
    }

    @Override
    public int getItemViewType(int position) {
        return cardsTypes.get(position);
    }

}
