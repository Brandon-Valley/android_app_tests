package com.example.brandon.test_app_0;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static java.sql.Types.NULL;

public class StaticCards0Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_cards_0);
        Intent intent = getIntent();


        //define linear layout for activity
        final LinearLayout container = (LinearLayout)findViewById(R.id.linear_layout_0); // have to put this in .xml manually

        // Get the application context
        final Context mContext = getApplicationContext();






        //add top blank card
        // Initialize a new CardView
        final CardView card = new CardView(mContext);

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



        //relative layout for inside of card
        RelativeLayout cardRelativeLayout = new RelativeLayout(getApplicationContext());

        //define relative layout button
        RelativeLayout.LayoutParams buttonParams =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                                                RelativeLayout.LayoutParams.MATCH_PARENT);
        buttonParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);

        final ImageButton overflowBtn = new ImageButton(this);
        overflowBtn.setImageResource(R.drawable.baseline_more_vert_black_18dp); // https://material.io/tools/icons/?style=baseline
        overflowBtn.setLayoutParams(buttonParams);
//        overflowBtn.setOnClickListener(mGreenBallOnClickListener);
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
        tv.setText("CardView");
        tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);
        tv.setTextColor(Color.BLACK);
        cardRelativeLayout.addView(tv);

        card.addView(cardRelativeLayout);

        // Finally, add the CardView in root layout
        container.addView(card);













        // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ 1st card ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^


        //add big card
        CardView bigCard = new CardView(mContext);

        final LinearLayout bigCardViewLayout = new LinearLayout(getApplicationContext());
        bigCardViewLayout.setOrientation(LinearLayout.VERTICAL);

        // Set the CardView layoutParams
        LinearLayout.LayoutParams bigCardViewParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        bigCardViewParams.topMargin     = margin;
        bigCardViewParams.rightMargin   = margin;
        bigCardViewParams.leftMargin    = margin;
        bigCardViewParams.bottomMargin  = margin;


        // layout for inside of big card
//        RelativeLayout bigCardViewLayout = new RelativeLayout(getApplicationContext());
        bigCardViewLayout.setLayoutParams(bigCardViewParams);


        bigCard.setLayoutParams(bigCardViewParams);

        bigCard.setRadius(9);
        bigCard.setContentPadding(30, 30, 30, 30);  // these are margins for cards inside this card (green and yellow)
        bigCard.setCardBackgroundColor(Color.parseColor("BLUE"));
        bigCard.setMaxCardElevation(15);
        bigCard.setCardElevation(9);






        // more button for big card VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV



//        buttonParams2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);

        ImageButton horzOverflowBtn = new ImageButton(this);
        horzOverflowBtn.setImageResource(R.drawable.baseline_more_horiz_black_18dp); // https://material.io/tools/icons/?style=baseline


        LinearLayout.LayoutParams horzOverflowBtnParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, //width
                LinearLayout.LayoutParams.WRAP_CONTENT  //height
        );

        horzOverflowBtnParams.gravity = Gravity.RIGHT;


        horzOverflowBtn.setLayoutParams(horzOverflowBtnParams);
//        overflowBtn.setOnClickListener(mGreenBallOnClickListener);

        horzOverflowBtn.setBackgroundColor(Color.TRANSPARENT);
;
        bigCardViewLayout.addView(horzOverflowBtn);





        //green card VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV


        //make 1st small card (green)
        CardView greenCard = new CardView(mContext);

        // Set the CardView layoutParams
        LinearLayout.LayoutParams greenCardParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );


        //these still have some effect, overide parent padding???
        greenCardParams.topMargin   = margin;
        greenCardParams.rightMargin = margin;
        greenCardParams.leftMargin  = margin;

        greenCardParams.height = 200;  //Only here b/c nothing inside card, without this param card height will shink to fit content


        greenCard.setLayoutParams(greenCardParams);

        greenCard.setRadius(9);
        greenCard.setContentPadding(30, 30, 30, 30);
        greenCard.setCardBackgroundColor(Color.parseColor("GREEN"));
        greenCard.setMaxCardElevation(15);
        greenCard.setCardElevation(9);

        bigCardViewLayout.addView(greenCard);





        // 1st spinner VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV


        final Spinner logicSpinner1 = new Spinner(mContext);//, R.style.Widget_AppCompat_Spinner_Underlined);

        List<String> logicSpinnerArray =  new ArrayList<String>();
        logicSpinnerArray.add("AND");
        logicSpinnerArray.add("OR");
        logicSpinnerArray.add("AND NOT");
        logicSpinnerArray.add("OR NOT");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, logicSpinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        logicSpinner1.setAdapter(adapter);

        LinearLayout.LayoutParams spinnerParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, //width
                LinearLayout.LayoutParams.WRAP_CONTENT  //height
        );

        spinnerParams.gravity = Gravity.CENTER;

//        ViewCompat.setBackgroundTintList(logicSpinner1, ColorStateList.valueOf(55));

        logicSpinner1.setLayoutParams(spinnerParams);


        container.addView(logicSpinner1);
//        bigCardViewLayout.addView(logicSpinner1);


        logicSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String text = logicSpinner1.getSelectedItem().toString();
                if (text == "AND")
                {
                    card.setCardBackgroundColor(Color.parseColor("RED"));
                }
                else
                {
                    card.setCardBackgroundColor(Color.parseColor("BLUE"));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });




        //radio button 1 VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV



        int num_buttons = 1;
        final RadioButton[] rb = new RadioButton[num_buttons];
        final RadioGroup rg = new RadioGroup(this); //create the RadioGroup
        rg.setOrientation(RadioGroup.HORIZONTAL);//or RadioGroup.VERTICAL
        for(int i=0; i<num_buttons; i++){
            rb[i]  = new RadioButton(this);
            rb[i].setText("TEXT ");

            rb[i].setId(i + 100);
            rg.addView(rb[i]);
        }

//        bigCardViewLayout.addView(rg);//you add the whole RadioGroup to the layout

//        rg.setVisibility(View.INVISIBLE);
//        rg.sethie

//https://developer.android.com/training/transitions/   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!







        // yellow card VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV



        //make 2nd small card (yellow)
        final CardView yellowCard = new CardView(mContext);

        // Set the CardView layoutParams
        LinearLayout.LayoutParams yellowCardParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );




        //these still have some effect, overide parent padding???
        yellowCardParams.topMargin   = margin;
        yellowCardParams.rightMargin = margin;
        yellowCardParams.leftMargin  = margin;

        yellowCardParams.height = 100;  //Only here b/c nothing inside card, without this param card height will shink to fit content


        yellowCard.setLayoutParams(yellowCardParams);

        yellowCard.setRadius(9);
        yellowCard.setContentPadding(30, 30, 30, 30);
        yellowCard.setCardBackgroundColor(Color.parseColor("YELLOW"));
        yellowCard.setMaxCardElevation(15);
        yellowCard.setCardElevation(9);

        bigCardViewLayout.addView(yellowCard);
//        container.addView(yellowCard);




        bigCard.addView(bigCardViewLayout);

//        bigCard.addView(greenCard);


        container.addView(bigCard);
//        bigCard.addView(card);



        //popup menue for more button VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV





        overflowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu menu = new PopupMenu(mContext, v);
                menu.getMenu().add(Menu.NONE, 1, 1, "delete / move radio button");
                menu.getMenu().add(Menu.NONE, 2, 2, "edit / remove card test");
                menu.getMenu().add(Menu.NONE, 3, 3, "move / change width test");
                menu.show();


                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        int i = item.getItemId();
                        CharSequence a = item.getTitle();
                        tv.setText("CardView" + a + i);

                        if (i == 1) {
                            //handle share
                            card.setCardBackgroundColor(Color.parseColor("GREEN"));

                            //move radio button
//                            bigCardViewLayout.removeView(rg);
                            bigCardViewLayout.removeView(yellowCard);
                            bigCardViewLayout.addView(rg);
                            bigCardViewLayout.addView(yellowCard);

                            return true;
                        } else if (i == 2) {
                            card.setCardBackgroundColor(Color.parseColor("YELLOW"));
                            container.removeView(card);
                            //handle comment
                            return true;
                        } else {
                            card.setCardBackgroundColor(Color.parseColor("BLUE"));
                            cardViewParams.height = 400;

                            card.setLayoutParams(cardViewParams);
                            return false;
                        }
                    }

                });

            }
        });



















    }
}
