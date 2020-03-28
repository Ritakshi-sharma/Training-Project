package com.example.nanny_project.NANI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.agrawalsuneet.dotsloader.loaders.CircularDotsLoader;
import com.example.nanny_project.R;

public class Splash_Screen extends AppCompatActivity {
CircularDotsLoader circularDotsLoader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__sreen);


       Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(Splash_Screen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },5000);

circularDotsLoader=findViewById(R.id.circular_loader);

        CircularDotsLoader loader = new CircularDotsLoader(this);
        loader.setDefaultColor(ContextCompat.getColor(this,R.color.colorTransparentWhite));
        loader.setSelectedColor(ContextCompat.getColor(this,R.color.colorTransparentWhite));
        loader.setBigCircleRadius(80);
        loader.setRadius(20);
        loader.setAnimDur(30);
        loader.setShowRunningShadow(true);
        loader.setFirstShadowColor(ContextCompat.getColor(this, R.color.colorTransparentWhite));
        loader.setSecondShadowColor(ContextCompat.getColor(this, R.color.colorTransparentWhite));
    }
}
