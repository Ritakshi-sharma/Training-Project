package com.example.nanny_project.BUYER;

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

import com.example.nanny_project.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Buyer_Profile extends Fragment implements View.OnClickListener {
    TextView textView;
    RecyclerView horizontal;
    ArrayList<HorizontalBuyer> list_user;

    public Buyer_Profile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_buyer__profile, container, false);
       findIds(view);
        imagesrecycler();

        textView.setOnClickListener(this);
        textView.setText(Html.fromHtml("<u>Edit Profile</u>"));
        horizontal.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        horizontal.setAdapter(new HorizontalBuyerAdapter(list_user));
        return view;
    }

    private void imagesrecycler() {
        list_user=new ArrayList<>();
        list_user.add(new HorizontalBuyer(R.drawable.ic_user,"Ritakshi"));
        list_user.add(new HorizontalBuyer(R.drawable.ic_user,"Ritakshi"));
        list_user.add(new HorizontalBuyer(R.drawable.ic_user,"Ritakshi"));
        list_user.add(new HorizontalBuyer(R.drawable.ic_user,"Ritakshi"));
    }

    private void findIds(View view) {
        textView=view.findViewById(R.id.text_view);
        horizontal=view.findViewById(R.id.subscription_profile);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.text_view:
                startActivity(new Intent(getContext(),User_EditProfile.class));
                break;
        }


    }
}
