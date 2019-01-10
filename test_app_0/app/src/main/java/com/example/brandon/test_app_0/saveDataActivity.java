package com.example.brandon.test_app_0;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.arch.persistence.room.Room;
//import androidx.room.Room;

public class saveDataActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_data);

        //define linear layout for activity
        final LinearLayout container = (LinearLayout)findViewById(R.id.save_data_ll); // have to put this in .xml manually

        // Get the application context
        final Context mContext = getApplicationContext();


        CardDatabase db = Room.databaseBuilder(getApplicationContext(),
                CardDatabase.class, "database-name").build();

        CardDao cd = db.CardDatabaseDao();






        CardEntity card1 = new CardEntity();
        card1.firstName = "harald";
        card1.uid = 0;

//        cd.insertCardEntity(card1);

        Card_Stack cs = make_fake_card_stack();


////        List<Card> cl;
////        cl.add(c2);
//
////        draw_card_stack(cs);
//        Card c1 = new Card("RED", "jim");
////        draw_card(c1, container, mContext);
//        c1.draw(container, mContext);

        cs.draw(container, mContext);

    }



    public Card_Stack make_fake_card_stack() {
        //make test cared_stack
        Card_Stack cs = new Card_Stack();
        Card c1 = new Card("RED", "jim");
        Card c2 = new Card("BLUE", "jqm");
        Card c3 = new Card("GREEN", "jeem");
        cs.add_card(c1);
        cs.add_card(c2);
        cs.add_card(c3);
        return cs;
    }







    /** Called when the user taps the go to card activity button */
    public void goToAddCardActivity(View view) {
//        Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show();
        Intent intent = new Intent(this, addCardActivity.class);
        startActivity(intent);
    }
}
