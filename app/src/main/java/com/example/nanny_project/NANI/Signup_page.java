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

public class Signup_page extends AppCompatActivity {
TextView txt;
ImageButton imageButton,imageButton2;
EditText editText,editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);

        txt=findViewById(R.id.signin);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Signup_page.this, Signin_page.class);
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
        imageButton2=findViewById(R.id.id_button);
        editText2=findViewById(R.id.id_confirm);

        imageButton2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_UP:
                        editText2.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        imageButton2.setImageResource(R.drawable.ic_hide);
                        break;

                    case MotionEvent.ACTION_DOWN:
                        editText2.setInputType(InputType.TYPE_CLASS_TEXT);
                        imageButton2.setImageResource(R.drawable.ic_visibility);

                        break;
                }

                return true;
            }
        });

    }
}
