package com.example.nanny_project.NANI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.nanny_project.R;

public class Login_Page extends AppCompatActivity {
TextView txt;
ImageButton imageButton;
EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__page);
        txt=findViewById(R.id.signup);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Login_Page.this, Signup_page.class);
                startActivity(intent);
            }
        });

        imageButton=findViewById(R.id.id_search_button);
        editText=findViewById(R.id.id_search_EditText);

        imageButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_UP:
                        editText.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        imageButton.setImageResource(R.drawable.ic_hide);
                        break;

                    case MotionEvent.ACTION_DOWN:
                        editText.setInputType(InputType.TYPE_CLASS_TEXT);
                        imageButton.setImageResource(R.drawable.ic_visibility);

                        break;
                }

                return true;
            }
        });

    }
}
