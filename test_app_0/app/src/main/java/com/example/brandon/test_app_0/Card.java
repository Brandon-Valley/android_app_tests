package com.example.brandon.test_app_0;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.util.TypedValue;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Card {
    public String m_color;
    public String m_name;

    public Card(String color, String name) {
        m_color = color;
        m_name = name;
    }







    public void draw(LinearLayout container, Context mContext) {

        // Initialize a new CardView
        final CardView new_cardview = new CardView(mContext);

        // Set the CardView layoutParams
        final LinearLayout.LayoutParams cardViewParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

//        cardViewParams.layoutAnimationParameters

        int margin = 20;
        cardViewParams.topMargin     = margin;
        cardViewParams.rightMargin   = margin;
        cardViewParams.leftMargin    = margin;
        cardViewParams.bottomMargin  = margin;
        cardViewParams.height = 200;

        new_cardview.setLayoutParams(cardViewParams);

        new_cardview.setRadius(9);                                              // Set CardView corner radius
        new_cardview.setContentPadding(100, 30, 30, 30);   // Set cardView content padding
        new_cardview.setCardBackgroundColor(Color.parseColor(m_color)); // Set a background color for CardView
        new_cardview.setMaxCardElevation(15);                                  // Set the CardView maximum elevation
        new_cardview.setCardElevation(9);                                      // Set CardView elevation

        //relative layout for inside of card
        RelativeLayout cardRelativeLayout = new RelativeLayout(mContext);

        //define relative layout button
        RelativeLayout.LayoutParams buttonParams =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.MATCH_PARENT);
        buttonParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);

        final ImageButton overflowBtn = new ImageButton(mContext);
        overflowBtn.setImageResource(R.drawable.baseline_more_vert_black_18dp); // https://material.io/tools/icons/?style=baseline
        overflowBtn.setLayoutParams(buttonParams);

        overflowBtn.setBackgroundColor(Color.TRANSPARENT);
        cardRelativeLayout.addView(overflowBtn);

        //new relativeLayout for textView
        RelativeLayout.LayoutParams textViewParams =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.MATCH_PARENT);

        textViewParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);

        // Initialize a new TextView to put in CardView
        final TextView tv = new TextView(mContext);
        tv.setLayoutParams(textViewParams);
        tv.setText(m_name);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);
        tv.setTextColor(Color.BLACK);
        cardRelativeLayout.addView(tv);

        new_cardview.addView(cardRelativeLayout);

        // Finally, add the CardView in root layout
        container.addView(new_cardview);
    }

}
