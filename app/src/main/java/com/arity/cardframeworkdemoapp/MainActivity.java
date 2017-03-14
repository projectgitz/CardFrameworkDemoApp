package com.arity.cardframeworkdemoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.arity.cardframework.core.CardAdapter;
import com.arity.cardframework.core.CardRecyclerView;
import com.arity.cardframework.core.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Integer> cardTypes = new ArrayList<>();
    private CardRecyclerView cardList;
    private CardAdapter cardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cardTypes.clear();
        cardTypes.add(CardType.SAMPLE_BASE_LAYOUT);
        cardList = (CardRecyclerView) findViewById(R.id.card_list);
        cardAdapter = new CardAdapter(cardTypes, new MyCardProducer());
        cardList.setAdapter(cardAdapter);
        SpacesItemDecoration spacesItemDecoration = new SpacesItemDecoration(
                getResources().getDimensionPixelSize(R.dimen.card_margin_vertical_small));
        cardList.addItemDecoration(spacesItemDecoration);
    }

}
