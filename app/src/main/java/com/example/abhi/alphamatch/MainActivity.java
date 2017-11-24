package com.example.abhi.alphamatch;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static com.example.abhi.alphamatch.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {

        @Override

        protected void onCreate(Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            super.onCreate(savedInstanceState);
            setContentView(activity_main);

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    // TODO: Your application init goes here.
                    Intent mInHome = new Intent(MainActivity.this, GameIntro.class);
                    MainActivity.this.startActivity(mInHome);
                    MainActivity.this.finish();
                }
            }, 2000);
        }
    }


