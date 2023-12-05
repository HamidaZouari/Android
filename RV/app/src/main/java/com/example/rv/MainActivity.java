package com.example.rv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;




import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;


    public class MainActivity extends AppCompatActivity {
        DatabaseHelper dbHelper;
        private FloatingActionButton addsBtn;
        private RecyclerView recv;
        private ArrayList<Contact> userList;
        private UserAdapter userAdapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            dbHelper=new DatabaseHelper(this);

            userList = dbHelper.getAll();


            addsBtn = findViewById(R.id.addingBtn);
            recv = findViewById(R.id.mRecycler);


            userAdapter = new UserAdapter(this, userList);


            recv.setLayoutManager(new LinearLayoutManager(this));
            recv.setAdapter(userAdapter);


            addsBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addInfo();
                }
            });

        }

        private void addInfo() {


            LayoutInflater inflter = LayoutInflater.from(this);
            View v = inflter.inflate(R.layout.form, null);

            EditText userName = v.findViewById(R.id.userName);
            EditText userNo = v.findViewById(R.id.userNumber);

            AlertDialog.Builder addDialog = new AlertDialog.Builder(this);

            addDialog.setView(v);
            addDialog.setPositiveButton("Ok", (dialog, which) -> {
                String names = userName.getText().toString();
                String number = userNo.getText().toString();
                if(!names.equals("")&&!number
                        .equals("")) {
                    Contact c = new Contact(names, number);
                    userList.add(c);

                    dbHelper.addContact(c);
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.done, (ViewGroup) findViewById(R.id.aa));
                    TextView tv = (TextView) layout.findViewById(R.id.textView);
                    tv.setText("User added successfully");
                    Toast toast = new Toast(getApplicationContext());

                    toast.setDuration(Toast.LENGTH_LONG);
                    toast.setView(layout);
                    toast.show();

                    dialog.dismiss();

                    userAdapter.notifyItemInserted(userList.size() - 1);
                    userList = dbHelper.getAll();
                    userAdapter = new UserAdapter(this, userList);


                    recv.setAdapter(userAdapter);
                }else{
                    Toast.makeText(MainActivity.this,"Invalid",Toast.LENGTH_LONG).show();
                }

            });

            addDialog.setNegativeButton("Cancel", (dialog, which) -> {
                dialog.dismiss();
                Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show();


            });

            addDialog.create().show();
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {

            getMenuInflater().inflate(R.menu.menu,menu);
            MenuItem menuItem=menu.findItem(R.id.search);
            SearchView searchView=(SearchView) menuItem.getActionView();
            searchView.setQueryHint("Type here to search");
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    userList=dbHelper.getAll(newText);

                    userAdapter= new UserAdapter(MainActivity.this,userList);
                    recv.setAdapter(userAdapter);
                    return false;
                }
            });
            return super.onCreateOptionsMenu(menu);
        }
    }
