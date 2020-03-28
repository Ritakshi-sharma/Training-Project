package com.example.nanny_project.NANI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nanny_project.R;

import java.util.ArrayList;
import java.util.List;

public class Edit_profile extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    Spinner spinner;
    RecyclerView text_get;
    AdapterRecycler adapterRecycler;
    List<String> list=new ArrayList<>();
    ImageView iv_back,iv_menu,iv_notification;
    TextView tv_title,change_pswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        findIds();
        setRecycler();

        List<String> specialities = new ArrayList<String>();
        specialities.add("Indian Food");
        specialities.add("Indian Food1");
        specialities.add("Indian Food2");
        specialities.add("Indian Food3");
        specialities.add("Indian Food4");


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, specialities);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(this);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                list.add(parent.getSelectedItem().toString());
                adapterRecycler.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void setRecycler() {
        adapterRecycler=new AdapterRecycler(Edit_profile.this,list);
        text_get.setAdapter(adapterRecycler);
    }

    private void findIds() {
        text_get = findViewById(R.id.text_get);
        spinner = findViewById(R.id.spinner);

        iv_back=findViewById(R.id.iv_back);
        iv_back.setVisibility(View.VISIBLE);
        iv_back.setOnClickListener(this);

        iv_menu=findViewById(R.id.iv_menu);
        iv_menu.setVisibility(View.GONE);

        iv_notification=findViewById(R.id.iv_notification);
        iv_notification.setVisibility(View.GONE);

        tv_title=findViewById(R.id.tv_title);
        tv_title.setText("Edit Profile");

        change_pswd=findViewById(R.id.change_pswd);
        change_pswd.setOnClickListener(this);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String item = parent.getItemAtPosition(position).toString();

        Toast.makeText(parent.getContext(), "Selected:" + item, Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.change_pswd:
                startActivity(new Intent(Edit_profile.this, Change_password.class));
                break;
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
