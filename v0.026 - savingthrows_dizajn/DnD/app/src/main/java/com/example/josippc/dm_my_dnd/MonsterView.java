package com.example.josippc.dm_my_dnd;

import android.content.Intent;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MonsterView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster_view);
    }

    public void openMonsterInfo(View view) {
        Button b = (Button)view;
        String buttonText = b.getText().toString(); // buttonText je ono što želimo prenijeti, to je Monster TYPE.

        Intent intent = new Intent(this, Monster_Info.class);
        intent.putExtra("buttonText", buttonText);
        startActivity(intent);
    }
}
