package com.example.nanny_project.NANI;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nanny_project.NANI.Edit_profile;
import com.example.nanny_project.NANI.Horizontal;
import com.example.nanny_project.NANI.HorizontalAdapter;
import com.example.nanny_project.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements View.OnClickListener {
TextView textView,name;
RecyclerView recyclerView;
private ArrayList<Horizontal> listoffood;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_profile, container, false);
textView=view.findViewById(R.id.text_view);
textView.setOnClickListener(this);
textView.setText(Html.fromHtml("<u>Edit Profile</u>"));
recyclerView=view.findViewById(R.id.recycler_profile);
Food_list();
       recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL,false));
        //setting the adapter
        recyclerView.setAdapter(new HorizontalAdapter(listoffood));
        List<String> specialities = new ArrayList<String>();
        specialities.add("Neapolitan pasta");
        specialities.add("Chicken Rice");
        specialities.add("Som Tam");
        specialities.add("Seafood Paella");
        specialities.add("Potato Chips");
        specialities.add("Buttered Popcorn");
        name=view.findViewById(R.id.speciality_names);
        StringBuilder builder=new StringBuilder();
        for(String details:specialities){
            builder.append(details+"\n");
        }
        name.setText(builder.toString());


        return view;
    }

    private void Food_list() {
        listoffood=new ArrayList<>();
        listoffood.add(new Horizontal(R.drawable.pizza,"Pizza"));
        listoffood.add(new Horizontal(R.drawable.south,"Pizza"));
        listoffood.add(new Horizontal(R.drawable.pizza,"Pizza"));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.text_view:
                startActivity(new Intent(getContext(), Edit_profile.class));
                break;
        }
    }
}
