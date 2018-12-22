package com.example.brandon.test_app_0;

import java.util.List;

public class Card_Stack {
    public List<Card> m_card_list;

    public void add_card(Card new_card) {
        m_card_list.add(new_card);
    }

    public void del_card(Card card) {
        m_card_list.remove(card);
    }

}
