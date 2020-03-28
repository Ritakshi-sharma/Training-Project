package com.example.nanny_project.NANI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nanny_project.R;

import java.util.ArrayList;
import java.util.List;


public class AddItem extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {
RecyclerView recyclerView,text_get,allergies_get;
    private ArrayList<image_list> foodList;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter,adapterRecycler,allergies_adapter;
    private int count=0;
    TextView textView;
    Button increase,decrease;
    Spinner spinner,allergies_list;
    List<String> list=new ArrayList<>();
    List<String> list2=new ArrayList<>();
    CheckBox checkBox;
    public AddItem() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_add_item, container, false);
        findIds(view);
        setRecycler();
        Food_list();
        //Recycler view of fod image
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        recyclerView.setAdapter(new image_listAdapter(foodList));
        //Spinner for Specialities
        List<String> specialities = new ArrayList<String>();
        specialities.add("Indian Food");
        specialities.add("Indian Food1");
        specialities.add("Indian Food2");
        specialities.add("Indian Food3");
        specialities.add("Indian Food4");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(),R.layout.spinner_item, specialities);
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                list.add(parent.getSelectedItem().toString());
                adapterRecycler.notifyDataSetChanged();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        List<String> Allergies = new ArrayList<String>();
        Allergies.add("Irritation");
        Allergies.add("Rashes");
        Allergies.add("Indigestion");
        Allergies.add("Lactose ");
        ArrayAdapter<String> allergyAdapter = new ArrayAdapter<String>(getContext(),R.layout.spinner_item, Allergies);
        allergies_list.setAdapter(allergyAdapter);
        allergies_list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                list2.add(parent.getSelectedItem().toString());
                allergies_adapter.notifyDataSetChanged();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;

    }
    private void setRecycler() {
        adapterRecycler=new AdapterRecycler(getActivity(),list);
        text_get.setAdapter(adapterRecycler);

        allergies_adapter=new Allergies_adapter(getActivity(),list2);
        allergies_get.setAdapter(allergies_adapter);

    }

    private void findIds(View view) {
        recyclerView=view.findViewById(R.id.recycler_view);
        textView=view.findViewById(R.id.count);
        increase=view.findViewById(R.id.increase);
        increase.setOnClickListener(this);
        decrease=view.findViewById(R.id.decrease);
        decrease.setOnClickListener(this);
        text_get = view.findViewById(R.id.text_get);
        spinner = view.findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        checkBox=view.findViewById(R.id.checkbox);
        checkBox.setOnClickListener(this);
        allergies_get=view.findViewById(R.id.allergies_get);
        allergies_list=view.findViewById(R.id.allergies_list);
        allergies_list.setOnItemSelectedListener(this);
    }

    private void Food_list() {
        foodList=new ArrayList<>();
        foodList.add(new image_list(R.drawable.pizza));
        foodList.add(new image_list(R.drawable.pizza));
        foodList.add(new image_list(R.drawable.pizza));
        foodList.add(new image_list(R.drawable.pizza));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.increase:
                count++;
                textView.setText(Integer.toString(count));
                break;
            case R.id.decrease:
                if (count>0){
                    count--;
                    textView.setText(Integer.toString(count));}
                else
                    break;
            case R.id.checkbox:
                if(checkBox.isChecked()){
                    Toast.makeText(getActivity(),"Contains meat product",Toast.LENGTH_SHORT).show();
                }

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (view.getId()){
            case R.id.spinner:
                String item = parent.getItemAtPosition(position).toString();

                Toast.makeText(parent.getContext(), "Selected:" + item, Toast.LENGTH_SHORT).show();
            case R.id.allergies_list:
                String item2 = parent.getItemAtPosition(position).toString();

                Toast.makeText(parent.getContext(), "Selected:" + item2, Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

