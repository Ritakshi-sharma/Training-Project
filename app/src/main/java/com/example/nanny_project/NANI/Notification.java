package com.example.nanny_project.NANI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nanny_project.R;

import java.util.ArrayList;

public class
Notification extends AppCompatActivity implements View.OnClickListener {
    private ArrayList<notification_list> foodList;
    private RecyclerView notificationRecyclerView;
    private RecyclerView.Adapter notificationAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private ImageView iv_back, iv_menu, iv_notification;
    private TextView tv_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        notificationRecyclerView = findViewById(R.id.vertical);
        Food_List();
        findIds();

        notificationRecyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        notificationAdapter=new Notification_Adapter(foodList);
        notificationRecyclerView.setLayoutManager(layoutManager);
        notificationRecyclerView.setAdapter(notificationAdapter);
    }
    private void findIds(){
        tv_title =findViewById(R.id.tv_title);
        tv_title.setText("Notifications");

        iv_back = findViewById(R.id.iv_back);
        iv_back.setVisibility(View.VISIBLE);
        iv_back.setOnClickListener(this);

        iv_menu =findViewById(R.id.iv_menu);
        iv_menu.setVisibility(View.GONE);


        iv_notification=findViewById(R.id.iv_notification);
        iv_notification.setVisibility(View.GONE);

    }



    private void Food_List() {
        foodList=new ArrayList<>();
        foodList.add(new notification_list(R.drawable.pizza,"Good food ", "5 months "));
        foodList.add(new notification_list(R.drawable.pizza,"Good food ", "5 months "));
        foodList.add(new notification_list(R.drawable.pizza,"Good food ", "5 months "));
        foodList.add(new notification_list(R.drawable.pizza,"Good food ", "5 months "));
        foodList.add(new notification_list(R.drawable.pizza,"Good food ", "5 months "));
        foodList.add(new notification_list(R.drawable.pizza,"Good food ", "5 months "));
        foodList.add(new notification_list(R.drawable.pizza,"Good food ", "5 months "));

    }
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.iv_back:
                Intent intent=new Intent(Notification.this, NaniHomePage.class);
                startActivity(intent);
                break;

        }

    }
}
