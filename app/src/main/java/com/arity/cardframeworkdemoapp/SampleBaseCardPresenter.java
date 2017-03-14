package com.arity.cardframeworkdemoapp;

import android.util.Log;

import com.arity.cardframework.core.CardPresenter;
import com.arity.cardframework.core.CardViewInterface;
import com.arity.cardframework.model.APIResponse;

/**
 * Created by Santhosh on 3/14/2017.
 */

public class SampleBaseCardPresenter extends CardPresenter {

    private final CardViewInterface cardViewInterface;

    public SampleBaseCardPresenter(CardViewInterface cardViewInterface) {
        this.cardViewInterface = cardViewInterface;
    }

    @Override
    public void getCardData() {
        cardViewInterface.showProgress();
        updateCardUI(null);
    }

    @Override
    public void updateCardUI(APIResponse apiResponse) {
        cardViewInterface.hideProgress();
        ((SampleBaseViewInterface) cardViewInterface).updateSampleBaseHolderInfo();
    }

    @Override
    public void onAPIResponseError(boolean showErrorCard) {
    }

    @Override
    public void cancelNetworkRequest() {
    }

}
