package com.example.nanny_project.NANI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nanny_project.R;

import java.util.ArrayList;

public class Payment extends AppCompatActivity implements View.OnClickListener {
RecyclerView recyclerView;
ArrayList<payment_list> list;
RecyclerView.LayoutManager layoutManager;
RecyclerView.Adapter paymentAdapter;
private ImageView iv_back,iv_menu,iv_notification;
private TextView tv_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        findIds();
        User_List();
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        paymentAdapter=new paymentAdapter(list);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(paymentAdapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    private void findIds() {
        iv_back=findViewById(R.id.iv_back);
        iv_back.setVisibility(View.VISIBLE);
        iv_back.setOnClickListener(this);

        iv_menu =findViewById(R.id.iv_menu);
        iv_menu.setVisibility(View.GONE);

        tv_title=findViewById(R.id.tv_title);
        tv_title.setText("Payments");

        iv_notification=findViewById(R.id.iv_notification);
        iv_notification.setVisibility(View.GONE);
        recyclerView=findViewById(R.id.recycler_payment);
    }

    private void User_List() {
        list=new ArrayList<>();
        list.add(new payment_list(R.drawable.ic_user));
        list.add(new payment_list(R.drawable.ic_user));
        list.add(new payment_list(R.drawable.ic_user));
        list.add(new payment_list(R.drawable.ic_user));
        list.add(new payment_list(R.drawable.ic_user));
       
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.iv_back:
                Intent intent=new Intent(Payment.this, NaniHomePage.class);
                startActivity(intent);
        }
    }
}
