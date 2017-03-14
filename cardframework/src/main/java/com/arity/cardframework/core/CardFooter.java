package com.arity.cardframework.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arity.cardframework.R;

/**
 * Created by rkanl on 3/30/2016.
 */
public class CardFooter extends LinearLayout implements View.OnClickListener {

    private LinearLayout footerView;
    private View cardContainer;
    private View dividerView;
    private Card card;
    private String leftLinkText;
    private String rightLinkText;
    private boolean isRightLinkEnabled = false;
    private boolean isLeftLinkEnabled = false;

    public CardFooter(Context context) {
        super(context);
        addFooterView();
    }

    public CardFooter(Context context, AttributeSet attrs) {
        super(context, attrs);
        addFooterView();
    }

    public CardFooter(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        addFooterView();
    }

    public void addFooterView() {
        footerView = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_footer_layout, null);
        cardContainer = footerView.findViewById(R.id.card_footer_layout);
        dividerView = footerView.findViewById(R.id.card_border_line);
        footerView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        addView(footerView);
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setLeftFooterLinkText(String text) {
        if (footerView != null) {
            leftLinkText = text;
            TextView footerLeftLinkText = (TextView) footerView.findViewById(R.id.footer_left_text);
            footerLeftLinkText.setOnClickListener(this);
            footerLeftLinkText.setText(text);
            isLeftLinkEnabled = true;
        }
    }

    public void hideLeftFooterLinkText() {
        if (footerView != null) {
            TextView footerLeftLinkText = (TextView) footerView.findViewById(R.id.footer_left_text);
            footerLeftLinkText.setVisibility(View.GONE);
        }
    }

    public void showLeftFooterLinkText() {
        if (footerView != null) {
            TextView footerLeftLinkText = (TextView) footerView.findViewById(R.id.footer_left_text);
            footerLeftLinkText.setVisibility(View.VISIBLE);
        }
    }

    public void hideRightFooterLinkText() {
        if (footerView != null) {
            TextView footerLeftLinkText = (TextView) footerView.findViewById(R.id.footer_right_text);
            footerLeftLinkText.setVisibility(View.GONE);
        }
    }

    public void showRightFooterLinkText() {
        if (footerView != null) {
            TextView footerLeftLinkText = (TextView) footerView.findViewById(R.id.footer_right_text);
            footerLeftLinkText.setVisibility(View.VISIBLE);
        }
    }

    public void setRightFooterLinkText(String text) {
        if (footerView != null) {
            rightLinkText = text;
            TextView footerRightLinkText = (TextView) footerView.findViewById(R.id.footer_right_text);
            footerRightLinkText.setOnClickListener(this);
            footerRightLinkText.setText(text);
            isRightLinkEnabled = true;
        }
    }

    void enableDivider(boolean enable) {
        dividerView.setVisibility(enable ? VISIBLE : GONE);
    }

    void setFooterBackgroundColor(int color) {
        cardContainer.setBackgroundColor(color);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.footer_left_text) {
            TextView footerLeftLinkText = (TextView) v;
            card.onLeftLinkClick(footerLeftLinkText.getText().toString());
        } else if (v.getId() == R.id.footer_right_text) {
            card.onRightLinkClick(rightLinkText);
        }
    }

    public boolean isRightLinkEnabled() {
        return isRightLinkEnabled;
    }

    public boolean isLeftLinkEnabled() {
        return isLeftLinkEnabled;
    }
}
