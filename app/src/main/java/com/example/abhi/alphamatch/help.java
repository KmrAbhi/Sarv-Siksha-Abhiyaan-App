package com.example.abhi.alphamatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        TextView textView = (TextView)findViewById(R.id.help);
        textView.setText("Click on an alphabet. Then click on it's corresponding small or capital letter on the opposite side.Make sure you choose the same letter.");
    }
}
