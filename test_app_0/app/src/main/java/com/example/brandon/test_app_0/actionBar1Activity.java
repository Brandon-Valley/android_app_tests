package com.example.brandon.test_app_0;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class actionBar1Activity extends AppCompatActivity {

    private Object view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar1);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_2);


//        /** Called when the user taps the go to card activity button */
//        public void goToNameCardActivity(View view)
//        {
//            Intent intent = new Intent(this, nameCardActivity.class);
////            EditText editText = (EditText) findViewById(R.id.editTextNumCards);
////            String message = editText.getText().toString();
//////        println(message);
////            intent.putExtra(EXTRA_MESSAGE_2, message);
//            startActivity(intent);
//        }




        //add toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //dynamically add button to toolbar
        Button b2=new Button(this);
        b2.setText("()");
        b2.setTextSize(10);
        toolbar.addView(b2);


        //enable back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



//        /** Called when the user taps the go to card activity button */
//        public void goToNameCardActivity(View view) {
//            Intent intent = new Intent(this, nameCardActivity.class);
////            EditText editText = (EditText) findViewById(R.id.editTextNumCards);
////            String message = editText.getText().toString();
//////        println(message);
////            intent.putExtra(EXTRA_MESSAGE_2, message);
//            startActivity(intent);
//        }



        //setup floating action button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(actionBar1Activity.this, nameCardActivity.class);
                startActivity(intent);
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });











        // Get the application context
        Context mContext = getApplicationContext();

        //define linear layout
        LinearLayout container = (LinearLayout)findViewById(R.id.linear_layout_0);

        //define linear layout params
        // Set the CardView layoutParams
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );



//               //add text view
//        LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//        TextView tv=new TextView(this);
//        tv.setLayoutParams(lparams);
//        tv.setText("ON CREATE");
//        container.addView(tv);

        //make text view
        // Initialize a new TextView to put in CardView
        TextView tv = new TextView(mContext);
        tv.setLayoutParams(params);
        tv.setText("ON CREATE 0");
        tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 60);
        tv.setTextColor(Color.RED);

        // Finally, add the CardView in root layout
        container.addView(tv);

        tv.setText("ON CREATE 1");
    }

}
