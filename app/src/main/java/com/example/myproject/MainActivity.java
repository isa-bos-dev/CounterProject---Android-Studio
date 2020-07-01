package com.example.myproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int ACTIVITY_TWO = 1;
    private int ACTIVITY_THREE =2;
    private Button button;
    private TextView textLabel;
    private Button button2;
    private int clicks = 0;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ACTIVITY_TWO && resultCode == Activity.RESULT_OK)
        {
            clicks = data.getIntExtra("result", -1);
            textLabel.setText("Has clicado " + clicks +" veces");
        }
        if(requestCode == ACTIVITY_THREE && resultCode == Activity.RESULT_OK)
        {
            clicks = data.getIntExtra("result", -1);
            textLabel.setText("Aux. 2. El resultado es: " + clicks +" veces");
        }

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("value", clicks);
        editor.apply();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        clicks = preferences.getInt("value", 0);
        button = findViewById(R.id.button);
        textLabel = findViewById(R.id.label);
        button2 = findViewById(R.id.button2);
        textLabel.setText("#clicks: "+ clicks);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AuxiliarActivity.class);
                i.putExtra("value", clicks);
                startActivityForResult(i, ACTIVITY_TWO);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AuxiliarActivity2.class);
                i.putExtra("value",clicks);
                startActivityForResult(i, ACTIVITY_THREE);
            }
        });
    }


}
