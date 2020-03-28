package com.example.nanny_project.BUYER;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nanny_project.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChildAdapter  extends RecyclerView.Adapter<ChildAdapter.VerticalHolder>{
    private ArrayList<child> list_child;
    private ArrayList<child> list_child2;
    private int adapterPosition;

    public ChildAdapter(ArrayList<child> list_child, ArrayList<child> list_child2, int position) {
        this.list_child = list_child;
        this.list_child2 = list_child2;
        this.adapterPosition = position;
    }

    @NonNull
    @Override
    public ChildAdapter.VerticalHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.child,parent,false);
       VerticalHolder verticalHolder=new VerticalHolder(view);
       return verticalHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChildAdapter.VerticalHolder holder, int position) {
        if (adapterPosition == 0){
            holder.imageView.setImageResource(list_child.get(position).getImages());
            holder.textView.setText(list_child.get(position).getTitle());

        }
        else if (adapterPosition == 1){
            holder.imageView.setImageResource(list_child2.get(position).getImages());
            holder.textView.setText(list_child2.get(position).getTitle());
        }
        }

    @Override
    public int getItemCount() {
        if (adapterPosition == 0){
            return list_child.size();
        }else {
            return list_child2.size();
        }
    }

    public class VerticalHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        public VerticalHolder(@NonNull View view) {
            super(view);
            imageView=view.findViewById(R.id.food_image);
            textView=view.findViewById(R.id.food_name);
        }

    }
}
