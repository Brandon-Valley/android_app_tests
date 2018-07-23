package com.example.brandon.test_app_0;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class actionBar1Activity extends AppCompatActivity {

    private Object view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar1);


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



        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_2);
    }

}
