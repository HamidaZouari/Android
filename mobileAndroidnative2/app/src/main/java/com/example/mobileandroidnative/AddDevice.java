package com.example.mobileandroidnative;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddDevice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_device);
        Button b = findViewById(R.id.next);
        Button b2 = findViewById(R.id.skip);
        View.OnClickListener commonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddDevice.this,AddProfile.class);
                startActivity(intent);

            }
        };
        b.setOnClickListener(commonClickListener);
        b2.setOnClickListener(commonClickListener);

    }
}