package com.example.brandon.test_app_0;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.LinearLayout;

public class dynamicTest2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_test_2);


        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_2);

        
        //VVVVVVVVVVVVV  copied from static cards VVVVVVVVVVVVVVVVVVVVVVVVVVVV
        

        //define linear layout for activity
        LinearLayout bigOrangeCardLayout = (LinearLayout)findViewById(R.id.linear_layout_0); // have to put this in .xml manually

        // Get the application context
        Context mContext = getApplicationContext();



        //make 1st small card (green)
        CardView greenCard = new CardView(mContext);

        // Set the CardView layoutParams
        LinearLayout.LayoutParams greenCardParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        


        int margin = 10;
        //these still have some effect, overide parent padding???
        greenCardParams.topMargin   = margin;
        greenCardParams.rightMargin = margin;
        greenCardParams.leftMargin  = margin;

        greenCardParams.height = 200;  //change this to something about min hieght so it fits contents????


        greenCard.setLayoutParams(greenCardParams);

        greenCard.setRadius(9);
        greenCard.setContentPadding(30, 30, 30, 30);
        greenCard.setCardBackgroundColor(Color.parseColor("GREEN"));
        greenCard.setMaxCardElevation(15);
        greenCard.setCardElevation(9);

        bigOrangeCardLayout.addView(greenCard);









        //make 2nd small card (yellow)
        CardView yellowCard = new CardView(mContext);

        // Set the CardView layoutParams
        LinearLayout.LayoutParams yellowCardParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

//        int margin = 10;

        //these still have some effect, overide parent padding???
        yellowCardParams.topMargin   = margin;
        yellowCardParams.rightMargin = margin;
        yellowCardParams.leftMargin  = margin;

        yellowCardParams.height = 100;  //change this to something about min hieght so it fits contents????
        yellowCardParams.gravity = 50;


        yellowCard.setLayoutParams(yellowCardParams);

        yellowCard.setRadius(9);
        yellowCard.setContentPadding(30, 30, 30, 30);
        yellowCard.setCardBackgroundColor(Color.parseColor("YELLOW"));
        yellowCard.setMaxCardElevation(15);
        yellowCard.setCardElevation(9);

        bigOrangeCardLayout.addView(yellowCard);
//
//
//
//
//        bigCard.addView(bigCardViewLayout);

//        bigCard.addView(greenCard);


//        bigOrangeCardLayout.addView(bigCard);
//        bigCard.addView(card);



    }
}
