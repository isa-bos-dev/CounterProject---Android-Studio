package com.example.myproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AuxiliarActivity extends AppCompatActivity {

    private Button buttonSuma, buttonExit;
    private TextView textLabel;
    private int index = 0;

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("CURSO_ANDROID", "ESTOY EN ONRESUME");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("CURSO_ANDROID", "ESTOY EN ONSTOP");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("CURSO_ANDROID", "ESTOY EN ONPAUSE");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auxiliar);

        Log.d("CURSO_ANDROID", "ESTOY EN ONCREATE");
        buttonSuma = findViewById(R.id.button_suma);
        textLabel = findViewById(R.id.label);

        index = getIntent().getIntExtra("value", -1);
        textLabel.setText(index+"");

        buttonExit = findViewById(R.id.button_exit);
        buttonSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index++; //index += 1; index = index+1;
                textLabel.setText(index+"");
            }
        });

        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result",index);
                setResult(Activity.RESULT_OK, returnIntent);

                finish();
            }
        });
    }
}