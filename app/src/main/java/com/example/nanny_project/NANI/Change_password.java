package com.example.nanny_project.NANI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nanny_project.R;

public class Change_password extends AppCompatActivity implements View.OnClickListener {
    ImageView iv_back,iv_menu,iv_notification;
    TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        findIds();
    }

    private void findIds() {
        iv_back=findViewById(R.id.iv_back);
        iv_back.setVisibility(View.VISIBLE);
        iv_back.setOnClickListener(this);

        iv_menu=findViewById(R.id.iv_menu);
        iv_menu.setVisibility(View.GONE);

        iv_notification=findViewById(R.id.iv_notification);
        iv_notification.setVisibility(View.GONE);

        tv_title=findViewById(R.id.tv_title);
        tv_title.setText("Change Password");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                onBackPressed();
                break;

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
