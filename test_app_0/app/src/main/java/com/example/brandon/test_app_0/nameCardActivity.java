package com.example.brandon.test_app_0;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;

import com.example.brandon.test_app_0.TestClass;

public class nameCardActivity extends AppCompatActivity {
    public String activityName = "nameCardActivity";
    public static final String NEW_CARD_NAME = "com.example.brandon.test_app_0.NEW_CARD_NAME";

//    TestClass tc;

    TestClass tc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_card);

        // Get the Intent that started this activity
        Intent intent = getIntent();

        tc = getIntent().getExtras().getParcelable("tc");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!\n\n\n text !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + tc.testInt );

////        TestClass tc = new TestClass();
//        Serializable tcS = intent.getSerializableExtra("tc");
//        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!\n\n\n text !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" );
//
//        tc = tcS;
//        tc.testInt = 5;

    }



    /** Called when the user taps the Send button */
    public void sendCardName(View view) {
        tc.testInt += 5;
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!\n\n\n text !!!!!!!!!!!!!!!!!!!!!--------------------" + tc.testInt  );

        //get name of card entered by user
        EditText editText = (EditText) findViewById(R.id.editText_card_name);
        String cardName = editText.getText().toString();

        //make intent to send to action bar activity
        Intent Intent = new Intent(this, actionBar1Activity.class);
        Intent.putExtra("from", activityName);
        Intent.putExtra("cardName", cardName);
        Intent.putExtra("tc", tc);
        startActivity(Intent);
    }



}
