package com.example.tp4;

import static android.os.Build.VERSION_CODES.R;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
RadioGroup gender;
RadioButton rb,male,female;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gender=(RadioGroup) findViewById(R.id.Gender);
        button=findViewById(R.id.button);
        male=findViewById(R.id.male);
        female=findViewById(R.id.female);

        // gender.setOnCheckedChangeListener(this);
        /**button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int x=gender.getCheckedRadioButtonId();
                rb=findViewById(x);
                Toast.makeText(MainActivity.this,rb.getText(),Toast.LENGTH_SHORT).show();
            }
        });**/
        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return false;
            }
        });
        button.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                contextMenu.add(0,1,1,"M->f");
                contextMenu.add(0,2,2,"F->M");
            }
        });
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case 1:
                female.setChecked(true);break;
            case 2:
                male.setChecked(true);
        }
        return super.onContextItemSelected(item);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,1,"M->f");
        menu.add(0,2,2,"F->M");


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {

        switch(item.getItemId())
        {
            case 1:
            female.setChecked(true);break;
            case 2:
                male.setChecked(true);
        }
        return super.onOptionsItemSelected(item);
    }
}