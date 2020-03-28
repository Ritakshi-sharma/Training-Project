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

public class Order extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recyclerView;
    ArrayList<Order_list> order_lists;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter orderAdapter;
    private ImageView iv_back,iv_menu,iv_notification;
    private TextView tv_title;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        findIds();
        Order_List();
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        orderAdapter=new Order_Adapter(order_lists);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(orderAdapter);
    }

    private void findIds() {
        recyclerView=findViewById(R.id.recycler_order);

        iv_back=findViewById(R.id.iv_back);
        iv_back.setVisibility(View.VISIBLE);
        iv_back.setOnClickListener(this);

        iv_menu=findViewById(R.id.iv_menu);
        iv_menu.setVisibility(View.GONE);

        iv_notification=findViewById(R.id.iv_notification);
        iv_notification.setVisibility(View.GONE);

        tv_title=findViewById(R.id.tv_title);
        tv_title.setText("My Orders");




    }

    private void Order_List() {
        order_lists=new ArrayList<>();
        order_lists.add(new Order_list(R.drawable.pizza,"Pizza"));
        order_lists.add(new Order_list(R.drawable.south,"Dossa"));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                Intent intent=new Intent(Order.this, NaniHomePage.class);
                startActivity(intent);


        }
    }
}
