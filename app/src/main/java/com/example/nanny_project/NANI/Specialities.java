package com.example.nanny_project.NANI;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.nanny_project.R;

import java.util.ArrayList;
import java.util.List;


public class Specialities extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button btn;
    Spinner spinner;
    RecyclerView text_get;
    AdapterRecycler adapterRecycler;
    List<String> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_specialities);
        btn = findViewById(R.id.go_verify);
        text_get = findViewById(R.id.text_get);

        setRecycler();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Specialities.this, Verification.class);
                startActivity(intent);
            }
        });
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        List<String> specialities = new ArrayList<String>();
        specialities.add("Indian Food");
        specialities.add("Indian Food1");
        specialities.add("Indian Food2");
        specialities.add("Indian Food3");
        specialities.add("Indian Food4");


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, specialities);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);

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


        adapterRecycler=new AdapterRecycler(Specialities.this,list);
        text_get.setAdapter(adapterRecycler);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String item = parent.getItemAtPosition(position).toString();

        Toast.makeText(parent.getContext(), "Selected:" + item, Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

    }
}