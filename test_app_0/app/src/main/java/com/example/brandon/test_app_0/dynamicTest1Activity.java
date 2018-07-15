package com.example.brandon.test_app_0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class dynamicTest1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_test_1);



        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE_2);

        // Capture the layout's TextView and set the string as its text

        //TextView textView = findViewById(R.id.textView3);
        //textView.setText(message);





        Button b2=new Button(this);
        b2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        b2.setText("Dynamic");
        b2.setTextSize(30);
        //b2.setTextColor(b1.getTextColors());
        LinearLayout container = (LinearLayout)findViewById(R.id.linear_layout_0);
        container.addView(b2);



    }
}
