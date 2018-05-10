package com.example.josippc.dm_my_dnd;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class DmSheet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dm_sheet);

        Cursor c = null;
        DatabaseHelper myDbHelper = new DatabaseHelper(DmSheet.this);
        try {
            myDbHelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        try {
            myDbHelper.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }
        c = myDbHelper.myDataBase.query("dmsheet", null, null, null, null, null, null);

        int count = 0;
        if (c.moveToFirst()) {
            count += 1;
            } while (c.moveToNext());
        if (count == 0)
        {
            /*Toast.makeText(this, "This is my Toast1 message!",
                    Toast.LENGTH_LONG).show();*/
            // Odi u char creation view
            //openDmSheetCreation(View.);
        }
        else // Prikaži likove u view
        {
            Toast.makeText(this, "This is my Toast2 message!",
                    Toast.LENGTH_LONG).show();
        }
    }


    public void openDmSheetCreation(View view) {
        Intent intent = new Intent(this, DmSheetCreation.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
    }
}

