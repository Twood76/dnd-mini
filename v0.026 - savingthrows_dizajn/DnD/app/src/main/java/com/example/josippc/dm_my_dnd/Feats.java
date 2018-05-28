package com.example.josippc.dm_my_dnd;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

public class Feats extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            //Remove title bar
            this.requestWindowFeature(Window.FEATURE_NO_TITLE);
            //Remove notification bar
            //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_feats);
        }
}
