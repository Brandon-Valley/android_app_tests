package com.example.brandon.test_app_0;

import android.content.Context;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class Card_Stack {
    public List<Card> m_card_list = new ArrayList<>();

    public void add_card(Card new_card) {
        m_card_list.add(new_card);
    }

    public void del_card(Card card) {
        m_card_list.remove(card);
    }






    public void draw(LinearLayout container, Context mContext) {
        for (int i = 0; i < m_card_list.size(); i++) {
            m_card_list.get(i).draw(container, mContext);
        }
    }



}
