package com.example.nanny_project.BUYER;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nanny_project.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class OpenItem  extends Fragment implements View.OnClickListener {
    private int count=0;
    TextView textView;
    Button increase,decrease,chooseAddress,back_home;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_click,container,false);
        findIds(view);

        return view;
    }
    private void findIds(View view) {
        textView=view.findViewById(R.id.count);
        increase=view.findViewById(R.id.increaseone);
        increase.setOnClickListener(this);
        decrease=view.findViewById(R.id.decrease);
        decrease.setOnClickListener(this);

        chooseAddress=view.findViewById(R.id.choose_address);
        chooseAddress.setOnClickListener(this);

        back_home=view.findViewById(R.id.back_home);
        back_home.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.increaseone:
                count++;
                textView.setText(Integer.toString(count));
                break;
            case R.id.decrease:
                if (count>0){
                    count--;
                    textView.setText(Integer.toString(count));}
                else
                    break;

                break;

            case R.id.choose_address:
                startActivity(new Intent(getContext(),Address.class));
                break;
            case R.id.back_home:
                getFragmentManager().beginTransaction().replace(R.id.fragment_container,new BuyerHomeFragment()).commit();
                break;


        }
    }

}
