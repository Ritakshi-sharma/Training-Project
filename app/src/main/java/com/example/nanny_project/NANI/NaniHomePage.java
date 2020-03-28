package com.example.nanny_project.NANI;

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
import android.widget.Toast;

import com.example.nanny_project.BUYER.buyerhome;
import com.example.nanny_project.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class NaniHomePage extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemSelectedListener{
    BottomNavigationView bottomNavigationView;
    NavigationView navigationView;
    private ImageView iv_back, iv_menu, iv_notification;
    private TextView tv_title;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        findIds();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

    }

    private void findIds() {
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        tv_title = findViewById(R.id.tv_title);
        tv_title.setText("Home");

        iv_back = findViewById(R.id.iv_back);
        iv_back.setVisibility(View.GONE);

        iv_menu = findViewById(R.id.iv_menu);
        iv_menu.setVisibility(View.VISIBLE);
        iv_menu.setOnClickListener(this);

        iv_notification=findViewById(R.id.iv_notification);
        iv_notification.setVisibility(View.VISIBLE);
        iv_notification.setOnClickListener(this);

    }






    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.home:
                tv_title.setText("Home");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HomeFragment()).commit();
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                break;
            case R.id.my_order:
                tv_title.setText("Discover");
                startActivity(new Intent(NaniHomePage.this, Order.class));
                Toast.makeText(this, "Discover", Toast.LENGTH_SHORT).show();
                break;
            case R.id.add:
                tv_title.setText("Add");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AddItem()).commit();

                Toast.makeText(this, "Add details", Toast.LENGTH_SHORT).show();
                break;
            case R.id.profile:
                tv_title.setText("Profile");
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ProfileFragment()).commit();
                Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
                break;

            case R.id.settings:
                tv_title.setText("Settings");
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Settings_fragment()).commit();
                break;
            case R.id.orders:
                Intent intent2=new Intent(NaniHomePage.this,Order.class);
                startActivity(intent2);
                Toast.makeText(this,"Order",Toast.LENGTH_SHORT).show();
                drawerLayout.openDrawer(Gravity.LEFT);
                break;
            case R.id.payment:
                Intent intent=new Intent(NaniHomePage.this, Payment.class);
                startActivity(intent);
                break;
            case R.id.switch_user:
                startActivity(new Intent(NaniHomePage.this, buyerhome.class));
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.iv_menu:
                drawerLayout.openDrawer(Gravity.LEFT);
                break;
            case R.id.iv_notification:
                Intent intent=new Intent(NaniHomePage.this, Notification.class);
                startActivity(intent);

                break;
        }
    }
}
