package com.example.mobileandroidnative;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ChildDashboard extends AppCompatActivity {
private BottomNavigationView bnv;
private FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_dashboard);

        bnv=findViewById(R.id.bottom);
        frameLayout=findViewById(R.id.frameLayout);
bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.dashboard) {
            loadFragment(new DashboardFragment(),false);

        } else if (itemId == R.id.phone) {
            loadFragment(new ControllFragment(),false);
        }
return true;

    }
});
loadFragment(new DashboardFragment(),true);
    }
    private void loadFragment(Fragment fragment,Boolean isAppInitailized){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        if(isAppInitailized){
            fragmentTransaction.add(R.id.frameLayout,fragment);
        }else {
            fragmentTransaction.replace(R.id.frameLayout, fragment);
        }fragmentTransaction.commit();
    }
}