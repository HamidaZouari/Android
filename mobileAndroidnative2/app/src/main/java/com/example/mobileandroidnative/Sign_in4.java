package com.example.mobileandroidnative;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sign_in4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in4);
         Button b = findViewById(R.id.parent);
        b.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(Sign_in4.this,Bienvenu.class);
            startActivity(intent);
            //finishAffinity();

    };
});
    }
}