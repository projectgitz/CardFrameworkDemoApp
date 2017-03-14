package com.arity.cardframework.core;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;

import com.arity.cardframework.R;

/**
 * Created by rkanl on 3/30/2016.
 */
public abstract class Card extends RecyclerView.ViewHolder implements CardViewInterface, CardObserver {

    private CardHeader cardHeader;
    private FrameLayout mainContainer;
    private CardFooter cardFooter;
    private boolean isCardHasFooter;
    private Integer cardType;
    public Context context;
    private CardPresenter cardPresenter;
    public CardObservable cardObservable;
    private Bundle savedInstanceState;

    public Card(View itemView) {
        super(itemView);
        cardHeader = (CardHeader) itemView.findViewById(R.id.card_header);
        mainContainer = (FrameLayout) itemView.findViewById(R.id.card_main_layout);
        cardFooter = (CardFooter) itemView.findViewById(R.id.card_footer);
        context = itemView.getContext();
    }

    public abstract void setCardMainContent();

    public void addMainContentView(View mainView) {
        mainContainer.removeAllViews();
        mainContainer.addView(mainView);
    }

    public void updateCardHeaderTitle(String title) {
        if (cardHeader != null) {
            cardHeader.setHeaderText(title);
        }
    }

    public void hideCardHeader() {
        if (cardHeader != null) {
            cardHeader.setVisibility(View.GONE);
        }
    }

    public void showCardHeader() {
        if (cardHeader != null) {
            cardHeader.setVisibility(View.VISIBLE);
        }
    }

    public void hideCardFooter() {
        if (cardFooter != null) {
            cardFooter.setVisibility(View.GONE);
        }
    }

    public void showCardFooter() {
        if (cardFooter != null) {
            cardFooter.setVisibility(View.VISIBLE);
        }
    }

    public void updateCardFooterLeftLinkText(String leftLinkText) {
        if (cardFooter != null) {
            cardFooter.setLeftFooterLinkText(leftLinkText);
        }
    }

    public void updateCardFooterRightLinkText(String rightLinkText) {
        if (cardFooter != null) {
            cardFooter.setRightFooterLinkText(rightLinkText);
        }
    }

    public void hideCardFooterLeftLink() {
        if (cardFooter != null) {
            cardFooter.hideLeftFooterLinkText();
        }
    }

    public void showCardFooterLeftLink() {
        if (cardFooter != null) {
            cardFooter.showLeftFooterLinkText();
        }
    }

    public void hideCardFooterRightLink() {
        if (cardFooter != null) {
            cardFooter.hideRightFooterLinkText();
        }
    }

    public void showCardFooterRightLink() {
        if (cardFooter != null) {
            cardFooter.showRightFooterLinkText();
        }
    }

    public void isCardHasFooter(boolean isCardHasFooter) {
        this.isCardHasFooter = isCardHasFooter;
        if (isCardHasFooter) {
            if (cardFooter != null) {
                cardFooter.setCard(this);
                showCardFooter();
            }
        } else {
            hideCardFooter();
        }
    }

    public void showFooterDivider(boolean show) {
        cardFooter.enableDivider(show);
    }

    public void setCardFooterBackgroundColor(int color) {
        cardFooter.setFooterBackgroundColor(color);
    }

    public void onLeftLinkClick(String linkText) {
    }

    public void onRightLinkClick(String linkText) {
    }

    public View getCardView() {
        return itemView;
    }

    public abstract void populateCardData();

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public CardPresenter getCardPresenter() {
        return cardPresenter;
    }

    public void setCardPresenter(CardPresenter cardPresenter) {
        this.cardPresenter = cardPresenter;
    }

    @Override
    public void onScroll() {
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onPause() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        this.savedInstanceState = savedInstanceState;
    }

    @Override
    public void onDestroy() {
        onCardDetachedFromWindow();
    }

    public void setCardObservable(CardObservable cardObservable) {
        this.cardObservable = cardObservable;
    }

    public void onCardAttachedToWindow() {
    }

    public void onCardDetachedFromWindow() {
    }

    public Bundle getSavedInstanceState() {
        return savedInstanceState;
    }

}
