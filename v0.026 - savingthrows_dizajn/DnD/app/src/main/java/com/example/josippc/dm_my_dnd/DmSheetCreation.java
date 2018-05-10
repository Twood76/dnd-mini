package com.example.josippc.dm_my_dnd;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.app.Activity;
import android.widget.Toast;

public class DmSheetCreation extends AppCompatActivity {

    Spinner spinnerStyleChange;
    Spinner spinnerStyleChange2;

    String[] number = new String[]{
            "Level...",
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12",
            "13",
            "14",
            "15",
            "16",
            "17",
            "18",
            "19",
            "20"
    };
    String[] classes = new String[]{
        "Class...",
        "Barbarian",
        "Bard",
        "Cleric",
        "Druid",
        "Fighter",
        "Monk",
        "Paladin",
        "Ranger",
        "Rogue",
        "Sorcerer",
        "Warlock",
        "Wizard"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dm_sheet_creation);

            spinnerStyleChange = (Spinner)findViewById(R.id.level);
            ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                    this,R.layout.my_spinner_style, number);
            spinnerArrayAdapter.setDropDownViewResource(R.layout.my_spinner_style);
            spinnerStyleChange.setAdapter(spinnerArrayAdapter);
            spinnerStyleChange.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                    // TODO Auto-generated method stub
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    // TODO Auto-generated method stub

                }
            });

            // drugi spinner
            spinnerStyleChange2 = (Spinner)findViewById(R.id.charclass);
            ArrayAdapter<String> spinnerArrayAdapter2 = new ArrayAdapter<String>(
                    this,R.layout.my_spinner_style, classes);
            spinnerArrayAdapter2.setDropDownViewResource(R.layout.my_spinner_style);
            spinnerStyleChange2.setAdapter(spinnerArrayAdapter2);
            spinnerStyleChange2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });


        }


}

