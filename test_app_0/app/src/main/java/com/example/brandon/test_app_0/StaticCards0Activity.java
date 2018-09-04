package com.example.brandon.test_app_0;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static java.sql.Types.NULL;

public class StaticCards0Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_cards_0);
        Intent intent = getIntent();


        //define layout
        LinearLayout container = (LinearLayout)findViewById(R.id.linear_layout_0); // have to put this in .xml manually

        // Get the application context
        Context mContext = getApplicationContext();






        //add top blank card
        // Initialize a new CardView
        CardView card = new CardView(mContext);

        // Set the CardView layoutParams
        LinearLayout.LayoutParams cardViewParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        int margin = 10;
        cardViewParams.topMargin   = margin;
        cardViewParams.rightMargin = margin;
        cardViewParams.leftMargin  = margin;
        cardViewParams.height = 200;


        card.setLayoutParams(cardViewParams);

        // Set CardView corner radius
        card.setRadius(9);

        // Set cardView content padding
        card.setContentPadding(100, 30, 30, 30);

        // Set a background color for CardView
        card.setCardBackgroundColor(Color.parseColor("RED"));

        // Set the CardView maximum elevation
        card.setMaxCardElevation(15);

        // Set CardView elevation
        card.setCardElevation(9);


//        // Set the overflow button layoutParams
//        LinearLayout.LayoutParams overflowBtnParams = card.getLayoutParams(
////                cardv.LayoutParams.MATCH_PARENT,
////                LinearLayout.LayoutParams.WRAP_CONTENT
//        );

//        RelativeLayout simpleRelativeLayout;
//        simpleRelativeLayout.setid = simpleRelativeLayout;
//        simpleRelativeLayout = (RelativeLayout) ;findViewById(R.id.simpleRelativeLayout);

//        RelativeLayout.LayoutParams cardRelativeLayout =
//                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
//                        RelativeLayout.LayoutParams.MATCH_PARENT);

        RelativeLayout cardRelativeLayout = new RelativeLayout(getApplicationContext());

        //define relative layout button
        RelativeLayout.LayoutParams buttonParams =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                                                RelativeLayout.LayoutParams.MATCH_PARENT);

        buttonParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);

//        buttonParams.topMargin   = margin;
//        buttonParams.rightMargin = card.getWidth();
//        buttonParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
//        buttonParams.lay
        //buttonParams.leftMargin  = margin;
        //cardViewParams.height = 200;

        ImageButton overflowBtn = new ImageButton(this);
        overflowBtn.setImageResource(R.drawable.baseline_more_vert_black_18dp);
        overflowBtn.setLayoutParams(buttonParams);
//        overflowBtn.setOnClickListener(mGreenBallOnClickListener);
        overflowBtn.setBackgroundColor(Color.TRANSPARENT);
        cardRelativeLayout.addView(overflowBtn);

        //new relativeLayout fro textView
        RelativeLayout.LayoutParams textViewParams =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                                                RelativeLayout.LayoutParams.MATCH_PARENT);

        textViewParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);

        // Initialize a new TextView to put in CardView
        TextView tv = new TextView(mContext);
        tv.setLayoutParams(textViewParams);
        tv.setText("CardView");
        tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);
        tv.setTextColor(Color.BLACK);
        cardRelativeLayout.addView(tv);

//        card.addView(tv);
//        card.addView(overflowBtn);
        card.addView(cardRelativeLayout);

        // Finally, add the CardView in root layout
        container.addView(card);






    }
}
