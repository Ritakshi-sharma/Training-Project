package com.example.nanny_project.NANI;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nanny_project.R;

public class MainActivity extends AppCompatActivity {
    //Declare all variables
private ViewPager viewPager;
private LinearLayout indicator;
private slider_adapter sliderAdapter;
private TextView[] dots;
Button button_nani,button_user;
private int custom_position=0;
    Boolean isOnePressed = false, isSecondPlace = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Finding ID of variables
viewPager=findViewById(R.id.slide_viewpager);
indicator=findViewById(R.id.indicator);

//Creating button click
button_nani=findViewById(R.id.nani);


button_nani.setOnClickListener(new View.OnClickListener() {
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View v) {

        Toast.makeText(MainActivity.this, "You are Nani", Toast.LENGTH_SHORT).show();
        isOnePressed = true;
        button_nani.setBackground(getDrawable(R.drawable.button_clicked));
        button_nani.setTextColor(Color.WHITE);
        if (isSecondPlace) {
            button_user.setBackground(getDrawable(R.drawable.button));
            button_user.setTextColor(Color.parseColor("#FFEF5350"));
            isSecondPlace = false;
        }
        Intent intent=new Intent(MainActivity.this, Login_Page.class);
        startActivity(intent);


    }
});

button_user=findViewById(R.id.buyer);
button_user.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(MainActivity.this, "You are Buyer", Toast.LENGTH_SHORT).show();
        //isOnePressed = true;
        isSecondPlace = true;
        button_user.setBackground(getDrawable(R.drawable.button_clicked));
        button_user.setTextColor(Color.WHITE);

        if (isOnePressed) {
            button_nani.setBackground(getDrawable(R.drawable.button));
            button_nani.setTextColor(Color.parseColor("#FFEF5350"));
            isOnePressed = false;
        }


    }
});


//getting slider adapter

sliderAdapter=new slider_adapter(this);
viewPager.setAdapter(sliderAdapter);
//getting page position for dots
addDotsIndicator(custom_position++);

//Creating active dots
viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
      if(custom_position>2)
          custom_position=0;
      addDotsIndicator(custom_position++);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
});
    }
//creating dots

    public void addDotsIndicator(int position){
        //count the no of pages

        if(indicator.getChildCount()>0)
            indicator.removeAllViews();
        ImageView dots[] =new ImageView[3];

        for(int i=0;i<3;i++){
            dots[i]=new ImageView(this);
            if(i==position)
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.active_dots));
            else
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.inactive_dots));


            LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(4,0,4,0);
            indicator.addView(dots[i],layoutParams);


        }

    }



}
