package com.arity.cardframework.core;

import android.view.View;

/**
 * Created by rkanl on 4/6/2016.
 */
public abstract class ExpansionCard extends Card {

    private boolean isCardExpanded = false;

    public ExpansionCard(View itemView) {
        super(itemView);
    }

    public abstract void setExpandableView();

    public void expand(final View v) {
        v.setVisibility(View.VISIBLE);
        isCardExpanded = true;
    }

    public void collapse(final View v) {
        v.setVisibility(View.GONE);
        isCardExpanded = false;
    }

    public boolean isCardExpanded() {
        return isCardExpanded;
    }

}
