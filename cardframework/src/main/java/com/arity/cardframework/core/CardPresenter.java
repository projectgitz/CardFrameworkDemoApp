package com.arity.cardframework.core;

import com.arity.cardframework.model.APIResponse;

/**
 * Created by rkanl on 3/31/2016.
 */
public abstract class CardPresenter {
    public abstract void getCardData();

    public abstract void updateCardUI(APIResponse apiResponse);

    public void getCardExpandableViewData() {
    }

    public void updateCardExpandableView() {
    }

    public abstract void onAPIResponseError(boolean showErrorCard);

    public abstract void cancelNetworkRequest();
}
