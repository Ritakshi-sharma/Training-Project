package com.example.nanny_project.BUYER;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nanny_project.NANI.NaniHomePage;
import com.example.nanny_project.NANI.ProfileFragment;
import com.example.nanny_project.NANI.Settings_fragment;
import com.example.nanny_project.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class buyerhome extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemSelectedListener {
    ImageView iv_back,iv_menu,iv_notification;
    TextView tv_title;
    DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyerhome);
        findIds();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new BuyerHomeFragment()).commit();

    }

    private void findIds() {
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        drawerLayout=findViewById(R.id.drawer_layout);

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        iv_back=findViewById(R.id.iv_back);
        iv_back.setVisibility(View.GONE);

        iv_menu=findViewById(R.id.iv_menu);
        iv_menu.setVisibility(View.VISIBLE);
        iv_menu.setOnClickListener(this);

        iv_notification=findViewById(R.id.iv_notification);
        iv_notification.setVisibility(View.GONE);

        tv_title=findViewById(R.id.tv_title);
        tv_title.setText("Home");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_menu:
                drawerLayout.openDrawer(Gravity.LEFT);
                break;

        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.switch_nani:
                startActivity(new Intent(buyerhome.this, NaniHomePage.class));
                break;

            case R.id.home_user:
                tv_title.setText("Home");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new BuyerHomeFragment()).commit();
                break;

            case R.id.settings:
                tv_title.setText("Settings");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Settings_user()).commit();
                break;

            case R.id.profile:
                tv_title.setText("Profile");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Buyer_Profile()).commit();
                break;

            case R.id.discover:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Discover_Item()).commit();
               tv_title.setText("Discover");
               break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
