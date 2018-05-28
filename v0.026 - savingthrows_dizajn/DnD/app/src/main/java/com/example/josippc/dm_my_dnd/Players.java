package com.example.josippc.dm_my_dnd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class Players extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);
    }

        public void openFeats(View view) {
            Button b = (Button)view;
            String buttonText = b.getText().toString(); // buttonText je ono što želimo prenijeti, to je Feat TYPE.

            Intent intent = new Intent(this, Feats.class);
            intent.putExtra("buttonText", buttonText);
            startActivity(intent);

    }
}
