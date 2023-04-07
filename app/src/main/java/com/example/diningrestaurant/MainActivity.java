package com.example.diningrestaurant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.Navigation;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import com.example.diningrestaurant.fragment.DapurFragment;
import com.example.diningrestaurant.fragment.KasirFragment;
import com.example.diningrestaurant.fragment.PemesenanFragment;
import com.example.diningrestaurant.fragment.listItemFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public Button addButton,deleteButton,saveButton,cancelButton;
    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//            this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);
        NavigationView navigationView =findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new listItemFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_listitem);
        }

    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.nav_listitem:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new listItemFragment()).commit();
                break;
            case R.id.nav_dapur:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new DapurFragment()).commit();
                break;
            case R.id.nav_kasir:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new KasirFragment()).commit();
                break;
            case R.id.nav_pesan:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PemesenanFragment()).commit();
                break;
        }
    return true;
    }
}




