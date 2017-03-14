package com.arity.cardframework.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arity.cardframework.R;

/**
 * Created by rkanl on 3/30/2016.
 */
public class CardHeader extends LinearLayout {
    private LinearLayout headerView;

    public CardHeader(Context context) {
        super(context);
        addHeaderView();
    }

    public CardHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        addHeaderView();
    }

    public CardHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        addHeaderView();
    }

    private void addHeaderView() {
        headerView = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_header_layout, null);
        headerView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        addView(headerView);
    }

    public void setHeaderText(String text) {
        TextView headerText = (TextView) headerView.findViewById(R.id.header_text);
        headerText.setText(text);
    }
}
