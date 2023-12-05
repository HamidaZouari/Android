package com.example.mobileandroidnative;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Congrats extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congrats);
        Button b = findViewById(R.id.add);
        Button b2 = findViewById(R.id.cont);
        View.OnClickListener commonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Congrats.this,Congrats2.class);
                startActivity(intent);

            }
        };
        b.setOnClickListener(commonClickListener);
        b2.setOnClickListener(commonClickListener);

    }

}