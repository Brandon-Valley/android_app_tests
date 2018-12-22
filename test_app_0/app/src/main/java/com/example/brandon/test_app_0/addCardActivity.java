package com.example.brandon.test_app_0;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class addCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);


        //add values to color spinner

        Spinner color_spinner = (Spinner) findViewById(R.id.color_spinner);

        List<String> colorSpinnerArray =  new ArrayList<String>();

        colorSpinnerArray.add(getResources().getString(R.string.spinner_option_color_red));
        colorSpinnerArray.add(getResources().getString(R.string.spinner_option_color_blue));
        colorSpinnerArray.add(getResources().getString(R.string.spinner_option_color_green));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
        this, android.R.layout.simple_spinner_item, colorSpinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        color_spinner.setAdapter(adapter);

    }

    public void goToSaveDataActivity(View view) {
        Intent intent = new Intent(this, saveDataActivity.class);
        startActivity(intent);
    }


    public void addCard(View view) {
        //make card
        EditText card_name_et = (EditText) findViewById(R.id.edit_text_card_name);
        Spinner color_spinner = (Spinner) findViewById(R.id.color_spinner);

        String card_name = card_name_et.getText().toString();
        String card_color = color_spinner.getSelectedItem().toString();

        Card new_card = new Card(card_color, card_name);

        Snackbar.make(view, new_card.m_name + new_card.m_color, Snackbar.LENGTH_LONG)
        .setAction("Action", null).show();
    }





}
