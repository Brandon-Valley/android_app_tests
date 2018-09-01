package com.example.brandon.test_app_0;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class actionBar1Activity extends AppCompatActivity {
    public String activityName = "actionBar1Activity";

    private Object view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar1);

        // Get the Intent that started this activity and extract the string
        final Intent intent = getIntent();
//        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_2);
        String from = intent.getStringExtra("from");
        String msg = intent.getStringExtra("msg");


        TestClass tc = new TestClass();


        //make test class if from main
        if (from == "MainActivity")
        {
            tc.testInt ++;
        }
//        else if (from == "nameCardActivity java")
//        {
//            tc = intent.getSerializableExtra("tc");
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





        //setup floating action button
        tc.testInt += 2;
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!\n\n\n text !!!!!!!!!!!!!!!!!!!!!------------00--------" + tc.testInt  );
        final Intent intent2 = new Intent(actionBar1Activity.this, nameCardActivity.class);
        intent2.putExtra("fromActivity", activityName);
        intent2.putExtra("tc", tc);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
//                Intent intent = new Intent(actionBar1Activity.this, nameCardActivity.class);
//                Intent.putExtra("from", "MainActivity");
//                Intent.putExtra("msg", "TEST MSG from main Activity");

                startActivity(intent2);
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


        //dynamically make text view
        // Initialize a new TextView to put in CardView
        TextView tv = new TextView(mContext);
        tv.setLayoutParams(params);
        tv.setText("ON CREATE 0");
        tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 60);
        tv.setTextColor(Color.RED);

        // Finally, add the CardView in root layout
        container.addView(tv);

        tv.setText("ON CREATE 1");


        //dynamically make 2nd text view to show message from last activity
        // Initialize a new TextView to put in CardView
        TextView tv2 = new TextView(mContext);
        tv2.setLayoutParams(params);
        tv2.setText(from + "testInt = " + tc.testInt);
        tv2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 60);
        tv2.setTextColor(Color.RED);

        // Finally, add the CardView in root layout
        container.addView(tv2);












    }

}
