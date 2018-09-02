package com.example.brandon.test_app_0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;
import static java.sql.DriverManager.println;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.brandon.test_app_0.MESSAGE";
    public static final String EXTRA_MESSAGE_2 = "com.example.brandon.test_app_0.MESSAGE_2";
    public static final int EXTRA_INT_0 = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText2);
        String message = editText.getText().toString();
//        println(message);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    /** Called when the user taps the go to card activity button */
    public void goToCardActivity(View view) {
        Intent intent = new Intent(this, CardTestActivity.class);
        EditText editText = (EditText) findViewById(R.id.editTextNumCards);
        String message = editText.getText().toString();
//        println(message);
        intent.putExtra(EXTRA_MESSAGE_2, message);
        startActivity(intent);
    }



    /** Called when the user taps the go to card activity button */
    public void goToDynamicTest1Activity(View view) {
        Intent intent = new Intent(this, dynamicTest1Activity.class);
        EditText editText = (EditText) findViewById(R.id.editTextNumCards);
        String message = editText.getText().toString();
//        println(message);
        intent.putExtra(EXTRA_MESSAGE_2, message);
        startActivity(intent);
    }





    /** Called when the user taps the go to card activity button */
    public void goToDynamicTest2Activity(View view) {
        Intent intent = new Intent(this, dynamicTest2Activity.class);
        EditText editText = (EditText) findViewById(R.id.editTextNumCards);
        String message = editText.getText().toString();
//        println(message);
        intent.putExtra(EXTRA_MESSAGE_2, message);
        startActivity(intent);
    }




    /** Called when the user taps the go to card activity button */
    public void goToActionBar1Activity(View view) {
        Intent mIntent = new Intent(this, actionBar1Activity.class);
        mIntent.putExtra("from", "MainActivity");
        mIntent.putExtra("msg", "TEST MSG from main Activity");
        TestClass tc = new TestClass();
        tc.testInt = 1;
        mIntent.putExtra("tc", tc);
        startActivity(mIntent);
    }



    /** Called when the user taps the go to card activity button */
    public void goToStaticCards0Activity(View view) {
        Intent intent = new Intent(this, StaticCards0Activity.class);
        startActivity(intent);
    }
}
