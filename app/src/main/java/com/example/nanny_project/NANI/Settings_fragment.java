package com.example.nanny_project.NANI;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nanny_project.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Settings_fragment extends Fragment implements View.OnClickListener {
TextView terms,profile,faq;

    public Settings_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_settings_fragment, container, false);
        findIds(view);
        return view;
    }

    private void findIds(View view) {
        profile=view.findViewById(R.id.profile_settings);
        profile.setOnClickListener(this);
        terms=view.findViewById(R.id.terms);
        terms.setOnClickListener(this);
        faq=view.findViewById(R.id.faq);
        faq.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.terms:
                startActivity(new Intent(getContext(), Terms_conditions.class));
                break;

            case R.id.profile_settings:
                startActivity(new Intent(getContext(), Edit_profile.class));
                break;

            case R.id.faq:
                startActivity(new Intent(getContext(), FAQ.class));
                break;
        }
    }
}
