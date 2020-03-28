package com.example.nanny_project.BUYER;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nanny_project.BUYER.HorizontalBuyer;
import com.example.nanny_project.BUYER.HorizontalBuyerAdapter;
import com.example.nanny_project.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class BuyerHomeFragment extends Fragment implements VerticalBuyerAdapter.FoodClicked {
    RecyclerView horizontal,vertical;
    ArrayList<HorizontalBuyer> list_user;
    ArrayList<VerticalBuyer> list_user2;

    public BuyerHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_buyer_home, container, false);
        findIds(view);
        imagesrecycler();

        //Horizontal Adapter
        horizontal.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        horizontal.setAdapter(new HorizontalBuyerAdapter(list_user));
        //Vertical Adapter

        vertical.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        vertical.setAdapter(new VerticalBuyerAdapter(list_user2,getContext(),this));
        return view;
    }

    private void imagesrecycler() {
        list_user=new ArrayList<>();
        list_user.add(new HorizontalBuyer(R.drawable.ic_user,"Ritakshi"));
        list_user.add(new HorizontalBuyer(R.drawable.ic_user,"Ritakshi"));
        list_user.add(new HorizontalBuyer(R.drawable.ic_user,"Ritakshi"));
        list_user.add(new HorizontalBuyer(R.drawable.ic_user,"Ritakshi"));

        list_user2=new ArrayList<>();
        list_user2.add(new VerticalBuyer(R.drawable.pizza,"Ritakshi"));
        list_user2.add(new VerticalBuyer(R.drawable.pizza,"Ritakshi"));
        list_user2.add(new VerticalBuyer(R.drawable.pizza,"Ritakshi"));
        list_user2.add(new VerticalBuyer(R.drawable.pizza,"Ritakshi"));


    }

    private void findIds(View view) {

        horizontal=view.findViewById(R.id.horizontal_view);
        vertical=view.findViewById(R.id.vertical_view);

    }

    @Override
    public void getFoodItemClicked(int position) {
        Log.d("clicked","clicked");
        OpenItem is = new OpenItem();
        openFragment(is);

//        Bundle bundle = new Bundle();
//        bundle.putString("name","ritakshi");
//        bundle.putInt("image",R.drawable.pizza);

    }

    private void openFragment(OpenItem is) {
        FragmentTransaction fm=getFragmentManager().beginTransaction();
        fm.replace(R.id.fragment_container,is);
        fm.commit();

    }
}
