package com.arity.cardframeworkdemoapp;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.arity.cardframework.core.Card;
import com.arity.cardframework.core.CardHeader;

/**
 * Created by Santhosh on 3/14/2017.
 */

public class SampleBaseCard extends Card implements SampleBaseViewInterface {

    private RelativeLayout loadingSpinner;
    private View headerText;
    private final SampleBaseCardPresenter cardPresenter;

    public SampleBaseCard(View itemView) {
        super(itemView);
        setHeaderText(itemView);
        isCardHasFooter(false);
        setCardMainContent();
        cardPresenter = new SampleBaseCardPresenter(this);
    }

    public void setHeaderText(View headerText) {
        CardHeader cardHeader = (CardHeader) itemView.findViewById(R.id.card_header);
        cardHeader.setHeaderText("Sample Base Card");
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

    @Override
    public void setCardMainContent() {
        LayoutInflater inflater = LayoutInflater.from(itemView.getContext());
        LinearLayout mainContentLayout = (LinearLayout) inflater.inflate(R.layout.sample_base_layout, null);
        FrameLayout container = (FrameLayout) itemView.findViewById(R.id.card_main_layout);
        container.addView(mainContentLayout);
        loadingSpinner = (RelativeLayout) itemView.findViewById(R.id.loading_spinner);
    }

    @Override
    public void populateCardData() {
        cardPresenter.getCardData();
    }

    @Override
    public void updateSampleBaseHolderInfo() {
        TextView sampleBaseTextView = (TextView) itemView.findViewById(R.id.samplebaseTV);
        sampleBaseTextView.setText("Sample Base Card");
    }

}
