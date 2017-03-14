package com.arity.cardframework.core;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.arity.cardframework.R;

/**
 * Created by rkanl on 4/7/2016.
 */
public class CardWithList extends Card {

    private CardInnerRecyclerView cardItemListView;
    private RelativeLayout loadingSpinner;
    private RecyclerView.Adapter<CardListItem> cardListItemAdapter;
    private OnCardListItemClickListener onCardListItemClickListener;

    public CardWithList(View itemView) {
        super(itemView);
        cardItemListView = (CardInnerRecyclerView) itemView.findViewById(R.id.card_inner_list);
    }

    public void setAdapter(RecyclerView.Adapter<CardListItem> cardListItemAdapter) {
        this.cardListItemAdapter = cardListItemAdapter;
        cardItemListView.setAdapter(cardListItemAdapter);
    }

    @Override
    public void setCardMainContent() {
        loadingSpinner = (RelativeLayout) itemView.findViewById(R.id.loading_spinner);
        cardItemListView.setHasFixedSize(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(itemView.getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        cardItemListView.setLayoutManager(layoutManager);
        cardItemListView.addItemDecoration(new SimpleDividerItemDecoration(itemView.getContext().getResources()));
    }

    @Override
    public void populateCardData() {

    }

    public OnCardListItemClickListener getOnCardListItemClickListener() {
        return onCardListItemClickListener;
    }

    public void setOnCardListItemClickListener(OnCardListItemClickListener onCardListItemClickListener) {
        this.onCardListItemClickListener = onCardListItemClickListener;
    }

    @Override
    public void showProgress() {
        loadingSpinner.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        loadingSpinner.setVisibility(View.GONE);
    }

    @Override
    public void onSessionError(boolean showErrorCard) {

    }

    public void showCardList() {
        cardItemListView.setVisibility(View.VISIBLE);
    }

    public void hideCardList() {
        cardItemListView.setVisibility(View.GONE);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
    }

    @Override
    public void onDestroy() {
    }

}
