package com.example.nanny_project.NANI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nanny_project.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment  {
    //VARIABLES OF THE CLASS
RecyclerView horizontalrecycler,verticalrecycler;
ArrayList<Horizontal> listoffood;
ArrayList<Vertical> listoffood1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home,container,false);
        //FINDING THE IDS OF ALL THE VIEWS IN THiE SCREEN
        findIds(v);
        description();
        //setting the layout manager
        horizontalrecycler.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        //setting the adapter
        horizontalrecycler.setAdapter(new HorizontalAdapter(listoffood));
        //setting vertical layout
        verticalrecycler.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        verticalrecycler.setAdapter(new VerticalAdapter(listoffood1));

        return v;
    }

    private void description() {
        listoffood=new ArrayList<>();
        listoffood.add(new Horizontal(R.drawable.pizza,"Pizza"));
        listoffood.add(new Horizontal(R.drawable.south,"Dosa"));
        listoffood.add(new Horizontal(R.drawable.pizza,"Pizza"));

        listoffood1=new ArrayList<>();
        listoffood1.add(new Vertical(R.drawable.pizza,"Pizza"));
        listoffood1.add(new Vertical(R.drawable.south,"Dosa"));


    }

    private void findIds(View v) {
        horizontalrecycler= v.findViewById(R.id.horizontal_view);

        verticalrecycler=v.findViewById(R.id.vertical_view);


    }


}
