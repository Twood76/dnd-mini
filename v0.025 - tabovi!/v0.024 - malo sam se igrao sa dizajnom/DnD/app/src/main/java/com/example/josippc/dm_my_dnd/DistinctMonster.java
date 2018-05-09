package com.example.josippc.dm_my_dnd;

import android.database.Cursor;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.io.IOException;

public class DistinctMonster extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distinct_monster);

        Bundle b = getIntent().getExtras();
        final String monsterId = b.getString("monsterId");

        Cursor c = null;
        DatabaseHelper myDbHelper = new DatabaseHelper(DistinctMonster.this);
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


        String[] args = { monsterId };

        c = myDbHelper.myDataBase.query("monsters", null ,"_id=?", args,  null, null, "Name");

        if (c.moveToFirst()) {
            do {
                final TextView ime = findViewById(R.id.ime_monstera);
                ime.setText(c.getString(1));
                final TextView typeMonster = findViewById(R.id.type_monster);
                typeMonster.setText(c.getString(2));
                final TextView size = findViewById(R.id.size_monster);
                size.setText(c.getString(3));
                final TextView exp = findViewById(R.id.exp_monstera);
                exp.setText(c.getString(12));
                final TextView cr = findViewById(R.id.CR_monstera);
                cr.setText(c.getString(11));
                final TextView hp = findViewById(R.id.HP_monstera);
                if(c.getString(10) == null){
                    hp.setText(c.getString(7) + " (" + c.getString(8) + "d" + c.getString(9) + ")");
                }else hp.setText(c.getString(7) + " (" + c.getString(8) + "d" + c.getString(9) + " + " + c.getString(10) + ")");


                final TextView ac = findViewById(R.id.Ac_monstera);
                ac.setText(c.getString(6));

                final TextView str = findViewById(R.id.str_monstera);
                str.setText(c.getString(15));
                final TextView dex = findViewById(R.id.dex_monstera);
                dex.setText(c.getString(16));
                final TextView con = findViewById(R.id.con_monstera);
                con.setText(c.getString(17));
                final TextView intel = findViewById(R.id.int_monstera);
                intel.setText(c.getString(18));
                final TextView wis = findViewById(R.id.wis_monstera);
                wis.setText(c.getString(19));
                final TextView cha = findViewById(R.id.cha_monstera);
                cha.setText(c.getString(20));

                final TextView strST = findViewById(R.id.strST_monstera);
                strST.setText(c.getString(26));
                final TextView dexST = findViewById(R.id.dexST_monstera);
                dexST.setText(c.getString(27));
                final TextView conST = findViewById(R.id.conST_monstera);
                conST.setText(c.getString(28));
                final TextView intST = findViewById(R.id.intST_monstera);
                intST.setText(c.getString(29));
                final TextView wisST = findViewById(R.id.wisST_monstera);
                wisST.setText(c.getString(30));
                final TextView chaST = findViewById(R.id.chaST_monstera);
                chaST.setText(c.getString(31));

                final TextView base_speed = findViewById(R.id.speed_monstera);
                base_speed.setText(c.getString(21));
                final TextView burrow = findViewById(R.id.speedburrow_monstera);
                burrow.setText(c.getString(22));
                final TextView climb = findViewById(R.id.speedclimb_monstera);
                climb.setText(c.getString(23));
                final TextView fly = findViewById(R.id.speedfly_monstera);
                fly.setText(c.getString(24));
                final TextView swim = findViewById(R.id.speedswim_monstera);
                swim.setText(c.getString(25));

                final TextView align = findViewById(R.id.alignment_monstera);
                align.setText(c.getString(4));
                final TextView attacks = findViewById(R.id.attack1_monstera);
                attacks.setText(c.getString(37));
                final TextView resist = findViewById(R.id.resistances_monstera);
                resist.setText(c.getString(32));
                final TextView perks = findViewById(R.id.perks_monstera);
                perks.setText(c.getString(34));
                final TextView senses = findViewById(R.id.senses_monstera);
                senses.setText(c.getString(35));

            } while (c.moveToNext());
        }
    }
}
