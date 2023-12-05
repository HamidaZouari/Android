package com.example.mobileandroidnative;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ConfirmProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_profile);

        Button b = findViewById(R.id.add);
        Button b2 = findViewById(R.id.cont);
        Button b3 = findViewById(R.id.modify);

        View.OnClickListener commonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConfirmProfile.this,AddChild.class);
                startActivity(intent);

            }
        };
        b.setOnClickListener(commonClickListener);
        b3.setOnClickListener(commonClickListener);

        b2.setOnClickListener(commonClickListener);
    }
}