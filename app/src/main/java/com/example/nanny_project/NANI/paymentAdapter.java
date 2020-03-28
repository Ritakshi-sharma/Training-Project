package com.example.nanny_project.NANI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.nanny_project.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class paymentAdapter extends RecyclerView.Adapter<paymentAdapter.VerticalviewHolder> {
    private ArrayList<payment_list> list;
    public paymentAdapter(ArrayList<payment_list> list){this.list=list;}
    @NonNull
    @Override
    public VerticalviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  food= LayoutInflater.from(parent.getContext()).inflate(R.layout.payment_list,parent,false);
        VerticalviewHolder verticalviewHolder=new VerticalviewHolder(food);
        return verticalviewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalviewHolder holder, int position) {
holder.imageView.setImageResource(list.get(position).getImages());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class VerticalviewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public VerticalviewHolder(View view) {
            super(view);
            imageView=view.findViewById(R.id.user);
        }
    }
}
