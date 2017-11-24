package com.example.abhi.alphamatch;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class GameIntro extends AppCompatActivity {
    @Override
    public void onBackPressed() {
        finish();
//        moveTaskToBack(true);
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_intro);

        ImageView play_button = (ImageView) findViewById(R.id.button);
        play_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GameIntro.this, GameHome.class);
                finish();
                startActivity(i);
            }
        });

        final Button help = (Button)findViewById(R.id.button2);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(GameIntro.this, help.class);
                startActivity(i);

            }
    });


}}
