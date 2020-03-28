package com.example.nanny_project.BUYER;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nanny_project.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Discover_Item extends Fragment {
    RecyclerView vertical;
    ArrayList<parent> list_parent;

    public Discover_Item() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_discover__item, container, false);
      findIds(view);
      Item_method();
      vertical.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
      vertical.setAdapter(new ParentAdapter(list_parent,getContext()));
       return view;
    }

    private void Item_method() {
        list_parent=new ArrayList<>();
        list_parent.add(new parent("Ice-Cream"));
        list_parent.add(new parent("Chocolates"));
        list_parent.add(new parent("Neapolitan Pizza"));
        list_parent.add(new parent("Massaman Curry"));
        list_parent.add(new parent("Potato Chips"));
        list_parent.add(new parent("Masala Dosa"));
        list_parent.add(new parent("Buttered Popcorn"));
        list_parent.add(new parent("Samosas"));
        list_parent.add(new parent("Pies"));
        list_parent.add(new parent("Colour Popcorn"));
        list_parent.add(new parent("Donuts"));
    }

    private void findIds(View view) {
        vertical=view.findViewById(R.id.parent);
    }
}
