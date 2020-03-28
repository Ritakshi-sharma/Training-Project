package com.example.nanny_project.BUYER;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nanny_project.NANI.Change_password;
import com.example.nanny_project.R;

public class User_EditProfile extends AppCompatActivity implements View.OnClickListener {
    TextView pswdchange,tv_title;
    ImageView iv_back,iv_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__edit_profile);
        findIds();
    }

    private void findIds() {
        pswdchange=findViewById(R.id.change_pswduser);
        pswdchange.setOnClickListener(this);

        iv_back=findViewById(R.id.iv_back);
        iv_back.setVisibility(View.VISIBLE);
        iv_back.setOnClickListener(this);

        iv_menu=findViewById(R.id.iv_menu);
        iv_menu.setVisibility(View.GONE);

        tv_title=findViewById(R.id.tv_title);
        tv_title.setText("Edit Profile");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.change_pswduser:
                startActivity(new Intent(User_EditProfile.this, Change_password.class));
                break;
            case R.id.iv_back:
                onBackPressed();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
