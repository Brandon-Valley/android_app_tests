package com.example.brandon.test_app_0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class nameCardActivity extends AppCompatActivity {
    public static final String NEW_CARD_NAME = "com.example.brandon.test_app_0.NEW_CARD_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_card);

        // Get the Intent that started this activity
        Intent intent = getIntent();
    }




    /** Called when the user taps the Send button */
    public void sendCardName(View view) {
        //get name of card entered by user
        EditText editText = (EditText) findViewById(R.id.editText_card_name);
        String cardName = editText.getText().toString();

        //make intent to send to action bar activity
        Intent Intent = new Intent(this, actionBar1Activity.class);
        Intent.putExtra("from", "nameCardActivity java");
        Intent.putExtra("cardName", cardName);
        startActivity(Intent);
    }



}
